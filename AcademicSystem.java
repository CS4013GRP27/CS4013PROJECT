/**
 * The AcademicSystem class manages the academic structure, including departments and enrolled students.
 * It provides functionalities to add departments, courses, and students, as well as methods for data retrieval.
 * 
 * <p>Usage:
 * <ol>
 *    <li>Instantiate the AcademicSystem class to create an academic system.</li>
 *    <li>Add departments, courses, and students using appropriate methods.</li>
 *    <li>Retrieve student information or perform calculations based on the academic structure.</li>
 * </ol>
 * 
 * <p>Note: Ensure proper addition of students and departments to maintain the integrity of the academic system.
 * /

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AcademicSystem {
    private Map<Integer, Transcript> studentTranscripts;
    private List<Department> departments;
    private List<Student> students;

    public AcademicSystem() {
        this.studentTranscripts = new HashMap<>();
        this.departments = new ArrayList<>();
        this.departments = new ArrayList<>();
        this.students = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public List<Student> getStudents() {
        return students;
    }
    
    public double calculateOverallAverageQCA(List<Student> students) {
        ResultCalculator resultCalculator = new ResultCalculator();
        double totalQCA = 0.0;
        int totalStudents = students.size();

        for (Student student : students) {
            double studentQCA = resultCalculator.calculateQcaOneSemester(student.getModules());
            totalQCA += studentQCA;
        }

        if (totalStudents == 0) {
            return 0.0;
        }

        return totalQCA / totalStudents;
    }

    public boolean checkStudentProgression(Student student) {
        Transcript transcript = studentTranscripts.get(student.getStudentId());
        ResultCalculator resultCalculator = new ResultCalculator();

        Map<Module, String> moduleGrades = transcript.getModuleGrades();
        List<ModuleGrade> moduleGradesList = new ArrayList<>();
        for (Map.Entry<Module, String> entry : moduleGrades.entrySet()) {
            ModuleGrade moduleGrade = new ModuleGrade(entry.getKey(), entry.getValue());
            moduleGradesList.add(moduleGrade);
        }

        List<List<ModuleGrade>> allSemesterGrades = new ArrayList<>();
        allSemesterGrades.add(moduleGradesList);

        double overallQCA = resultCalculator.calculateQcaAllSemesters(allSemesterGrades);
        return overallQCA >= 2.0;
    }

    public boolean checkForRepeatModules(Student student) {
        Transcript transcript = studentTranscripts.get(student.getStudentId());

        Map<Module, String> moduleGrades = transcript.getModuleGrades();
        for (String grade : moduleGrades.values()) {
            if (grade.equals("F") || grade.equals("N") || grade.equals("NG") || grade.equals("I")) {
                return true;
            }
        }

        return false;
    }

    public List<Student> getStudentsByCourse(Course course) {
        List<Student> studentsInCourse = new ArrayList<>();

        for (Student student : students) {
            if (student.getCourse().equals(course)) {
                studentsInCourse.add(student);
            }
        }

        return studentsInCourse;
    }

    public double calculateOverallAverageQCA(Map<Integer, Student> students) {
    	ResultCalculator resultCalculator = new ResultCalculator();
    	double totalQCA = 0.0;
        int totalStudents = 0;

        for (Student student : students.values()) {
            double studentQCA =resultCalculator.calculateQcaOneSemester(student.getModules());
            totalQCA += studentQCA;
            totalStudents++;
        }

        if (totalStudents == 0) {
            return 0.0; 
        }

        return totalQCA / totalStudents;
    }

}
