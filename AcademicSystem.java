import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AcademicSystem {
    private Map<Integer, Transcript> studentTranscripts;
    private List<Department> departments;

    public AcademicSystem() {
        this.studentTranscripts = new HashMap<>();
        this.departments = new ArrayList<>();
    }

    public void addDepartment(Department department) {
        departments.add(department);
    }

    public void addStudent(Student student) {
        Transcript transcript = new Transcript(student);
        studentTranscripts.put(student.getStudentId(), transcript);
    }

    public double calculateOverallAverageQCA(Student student) {
        Transcript transcript = studentTranscripts.get(student.getStudentId());
        return transcript.calculateQCA();
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
        List<Student> students = new ArrayList<>();
        // Logic to retrieve students by course
        return students;
    }

    public String calculateOverallAverageQCA() {
        // Logic to calculate overall average QCA for all students
        return null;
    }
}
