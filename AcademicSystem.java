import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AcademicSystem {
    private Map<Integer, Transcript> studentTranscripts;
    private List<Department> departments;

    public AcademicSystem(List<Department> departments) {
        this.studentTranscripts = new HashMap<>();
        this.departments = departments;
    }

    public void generateTranscript(Student student) {
        Transcript transcript = new Transcript(student);
        transcript.generateTranscript();
        studentTranscripts.put(student.getStudentId(), transcript);
    }

    public Transcript getStudentTranscript(Student student) {
        return studentTranscripts.get(student.getStudentId());
    }

    public void submitResults(Faculty faculty, List<ModuleGrade> moduleGrades) {
        faculty.submitResultsForModules(moduleGrades);
    }

    public void holdExamBoard(Department department, ExamBoard examBoard) {
        department.holdExamBoard(examBoard);
    }

    public Transcript getFacultyTranscript(Faculty faculty) {
        return null;
    }
}
