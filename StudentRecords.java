import java.util.ArrayList;
import java.util.List;

public class StudentRecords {
    private List<Student> studentList;

    public StudentRecords() {
        this.studentList = new ArrayList<>();
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

    public List<Student> getStudentsByProgram(Program program) {
        List<Student> studentsByProgram = new ArrayList<>();
        for (Student student : studentList) {
            if (student.getProgram().equals(program)) {
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

    public double calculateOverallAverageGPA() {
        double totalGpa = 0.0;
        for (Student student : studentList) {
            totalGpa += student.calculateQCA();
        }
        return totalGpa / studentList.size();
    }
}
