import java.util.ArrayList;
import java.util.List;

public class StudentRecords {
    private List<Student> studentList;
    private ResultCalculator resultCalculator;

    public StudentRecords() {
        this.studentList = new ArrayList<>();
        this.resultCalculator = new ResultCalculator();
    }

    public void addStudent(Student student) {
        studentList.add(student);
    }

    public void removeStudent(Student student) {
        studentList.remove(student);
    }

    public Student findStudentById(int studentId) {
        for (Student student : studentList) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    public List<Student> getStudentsByCourse(Course course) {
        List<Student> studentsByProgram = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getCourse().equals(course)) {
                studentsByProgram.add(student);
            }
        }
        return studentsByProgram;
    }

    public List<Student> getStudents() {
        return studentList;
    }

    public void setStudents(List<Student> students) {
        this.studentList = students;
    }

    public double calculateOverallAverageQCA() {
        double totalQCA = 0.0;
        for (Student student : studentList) {
            totalQCA += resultCalculator.calculateQcaOneSemester(student.getModules());
        }
        return totalQCA / studentList.size();
    }
}
