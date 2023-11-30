import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TranscriptManager {
    private Map<Student, Transcript> transcriptMap;

    public TranscriptManager() {
        this.transcriptMap = new HashMap<>();
    }

    public void generateTranscript(Student student) {
        Transcript transcript = new Transcript(student);
        transcriptMap.put(student, transcript);
        transcript.generateTranscript();
    }

    public void printTranscript(Student student) {
        Transcript transcript = transcriptMap.get(student);
        if (transcript != null) {
            System.out.println("Printing Transcript for Student: " + student.getName());
            transcript.printTranscript();
        } else {
            System.out.println("Transcript not found for the student.");
        }
    }

    public void updateModuleGrade(Student student, Module module, String grade) {
        Transcript transcript = transcriptMap.get(student);
        if (transcript != null) {
            transcript.updateModuleGrade(module, grade);
        } else {
            System.out.println("Transcript not found for the student. Unable to update grade.");
        }
    }

    public List<Transcript> getAllTranscripts() {
        return new ArrayList<>(transcriptMap.values());
    }


    public Map<Student, Transcript> getTranscriptMap() {
        return transcriptMap;
    }

    public void setTranscriptMap(Map<Student, Transcript> transcriptMap) {
        this.transcriptMap = transcriptMap;
    }
}
