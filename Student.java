import java.util.ArrayList;
import java.util.List;

public class Student {
    private int studentId;
    private String name;
    private String email;
    private String address;
    private Program program;
    private List<ModuleGrade> modules;

    public Student(int studentId, String name, String email, String address, Program program) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.program = program;
        this.modules = new ArrayList<>();
    }

    public void addModuleGrade(Module module, String grade) {
        this.modules.add(new ModuleGrade(module.getModuleCode(), grade, module.getCredits()));
    }

    public double calculateQCA() {
        double totalCredits = 0.0;
        double totalGradePoints = 0.0;

        for (ModuleGrade moduleGrade : modules) {
            int credits = moduleGrade.getCreditValue();
            totalCredits += credits;
            totalGradePoints += convertGradeToPoint(moduleGrade.getGrade()) * credits;
        }

        if (totalCredits == 0) {
            return 0.0; // Avoid division by zero
        }

        return totalGradePoints / totalCredits;
    }

    private double convertGradeToPoint(String grade) {
        switch (grade) {
            case "A1":
                return 4.0;
            case "A2":
                return 3.6;
            case "B1":
                return 3.2;
            case "B2":
                return 3.0;
            case "B3":
                return 2.8;
            case "C1":
                return 2.6;
            case "C2":
                return 2.4;
            case "C3":
                return 2.0;
            case "D1":
                return 1.6;
            case "D2":
                return 1.2;
            case "F":
            case "NG":
            case "N":
                return 0.0;
            default:
                return 0.0;
        }
    }

    public Transcript viewOwnTranscript() {
        Transcript studentTranscript = new Transcript(this);
        studentTranscript.generateTranscript();
        return studentTranscript;
    }

    public Transcript provideTranscriptToFaculty() {
        Transcript studentTranscript = new Transcript(this);
        studentTranscript.generateTranscript();
        return studentTranscript;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Program getProgram() {
        return program;
    }

    public void setProgram(Program program) {
        this.program = program;
    }

    public List<ModuleGrade> getModules() {
        return modules;
    }

    public void setModules(List<ModuleGrade> modules) {
        this.modules = modules;
    }
}
