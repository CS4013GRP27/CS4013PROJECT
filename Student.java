import java.util.ArrayList;
import java.util.List;

public class Student {
    private int studentId;
    private String name;
    private String email;
    private String address;
    private Course course;
    private List<ModuleGrade> modules;

    public Student(int studentId, String name, String email, String address, Course course) {
        this.studentId = studentId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.course = course;
        this.modules = new ArrayList<>();
    }

    public void addModuleGrade(Module module, String grade) {
        this.modules.add(new ModuleGrade(module.getModuleCode(), grade, module.getCredits()));
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

    public Course getCourse() {
        return course;
    }

    public void setCourse(Program course) {
        this.course = course;
    }

    public List<ModuleGrade> getModules() {
        return modules;
    }

    public void setModules(List<ModuleGrade> modules) {
        this.modules = modules;
    }
}
