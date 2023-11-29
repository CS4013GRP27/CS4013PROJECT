import java.util.HashMap;
import java.util.Map;

public class Transcript {

    private Student student;
    private Map<Module, String> moduleGrades;

    public Transcript(Student student) {
        this.student = student;
        this.moduleGrades = new HashMap<>();
    }

    public void generateTranscript() {
        // logic to generate transcript
    }

    public void printTranscript() {
        // print transcript details
    }

    public void updateModuleGrade(Module module, String grade) {
        moduleGrades.put(module, grade);
    }

}
