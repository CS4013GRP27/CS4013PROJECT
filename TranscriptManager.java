import java.util.HashMap;
import java.util.Map;
import java.util.List;


public class TranscriptManager {
    private Map<Integer, Transcript> transcriptMap;

    public TranscriptManager() {
        this.transcriptMap = new HashMap<>();
    }

    public void generateTranscript(Student student) {
        Transcript transcript = new Transcript(student);
        transcript.generateTranscript();
        transcriptMap.put(student.getStudentId(), transcript);
    }

    public Transcript getTranscript(int studentId) {
        return transcriptMap.get(studentId);
    }

    public void printTranscript(int studentId) {
        Transcript transcript = transcriptMap.get(studentId);
        if (transcript != null) {
            transcript.printTranscript();
        } else {
            System.out.println("Transcript not found for student with ID: " + studentId);
        }
    }

    public void updateTranscript(Student student, Module module, String grade) {
        Transcript transcript = transcriptMap.get(student.getStudentId());
        if (transcript != null) {
            transcript.updateModuleGrade(module, grade);
        } else {
            System.out.println("Transcript not found for student with ID: " + student.getStudentId());
        }
    }

    public Transcript viewOwnTranscript(Student student) {
        return transcriptMap.get(student.getStudentId());
    }

    public Transcript provideTranscriptToFaculty(int studentId) {
        return transcriptMap.get(studentId);
    }

    public void submitResultsForModules(Faculty faculty, List<ModuleGrade> moduleGrades) {
        for (ModuleGrade moduleGrade : moduleGrades) {
        }
    }

    public void holdExamBoard(Department department, List<Student> students) {
        for (Student student : students) {
        }
    }
}


