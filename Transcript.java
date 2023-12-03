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
        System.out.println("Generating Transcript for Student: " + student.getName());
        // Logic to generate transcript based on moduleGrades
        // For example:
        System.out.println("Transcript Details:");
        for (Map.Entry<Module, String> entry : moduleGrades.entrySet()) {
            System.out.println(entry.getKey().getTitle() + " - Grade: " + entry.getValue());
        }
        System.out.println("Transcript generated successfully.");
    }

    public void printTranscript() {
        generateTranscript(); // Prints the transcript details
    }

    public void updateModuleGrade(Module module, String grade) {
        moduleGrades.put(module, grade);
    }

    // Other methods like finalizeGrades(), getGradeForModule(), etc.

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Map<Module, String> getModuleGrades() {
        return moduleGrades;
    }

    public void setModuleGrades(Map<Module, String> moduleGrades) {
        this.moduleGrades = moduleGrades;
    }

    public double calculateQCA() {
        return 0;
    }
}
