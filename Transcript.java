import java.util.ArrayList;
import java.util.List;

public class Transcript {
    private Student student;
    private List<ModuleGrade> moduleGrades;

    public Transcript(Student student) {
        this.student = student;
        this.moduleGrades = new ArrayList<>();
    }

    public void addModuleGrade(Module module, String grade) {
        ModuleGrade moduleGrade = new ModuleGrade(module, grade);
        moduleGrades.add(moduleGrade);
    }

    public void printTranscript() {
        System.out.println("Transcript for " + student.getName() + ":");
        for (ModuleGrade moduleGrade : moduleGrades) {
            System.out.println(moduleGrade.getModule().getName() + ": " + moduleGrade.getGrade());
        }
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public List<ModuleGrade> getModuleGrades() {
        return moduleGrades;
    }

    public void setModuleGrades(List<ModuleGrade> moduleGrades) {
        this.moduleGrades = moduleGrades;
    }
}
