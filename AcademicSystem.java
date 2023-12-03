import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AcademicSystem {
    private Map<Integer, Transcript> studentTranscripts;
    private List<Department> departments;

    public AcademicSystem() {
        this.studentTranscripts = new HashMap<>();
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
        return false;
    }

    public boolean checkForRepeatModules(Student student) {
        return false;
    }

    public List<Student> getStudentsByProgram(Course course1) {
        return null;
    }

    public String calculateOverallAverageQCA() {
        return null;
    }
}
