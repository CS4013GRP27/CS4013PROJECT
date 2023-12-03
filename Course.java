import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseCode;
    private String name;
    private String department;
    private String level;
    private int duration;
    private List<ModuleGrade> modulesOffered;
    private ProgramType courseType;
    private String courseFormat;

    public Course(String courseCode, String name, String department, String level, int duration,
                   ProgramType programType, String programFormat) {
        this.courseCode = courseCode;
        this.name = name;
        this.department = department;
        this.level = level;
        this.duration = duration;
        this.courseType = programType;
        this.courseFormat = programFormat;
        this.modulesOffered = new ArrayList<>();
    }

    public void addModuleGrade(Module module, String grade) {
        this.modulesOffered.add(new ModuleGrade(module, grade));
    }

    public double calculateProgramQCA(ResultCalculator calculator) {
        return calculator.calculateQcaOneSemester(modulesOffered);
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public List<ModuleGrade> getModulesOffered() {
        return modulesOffered;
    }

    public void setModulesOffered(List<ModuleGrade> modulesOffered) {
        this.modulesOffered = modulesOffered;
    }

    public ProgramType getCourseType() {
        return courseType;
    }

    public void setCourseType(ProgramType courseType) {
        this.courseType = courseType;
    }

    public String getCourseFormat() {
        return courseFormat;
    }

    public void setCourseFormat(String courseFormat) {
        this.courseFormat = courseFormat;
    }

    @Override
    public String toString() {
        return "Program{" +
                "courseCode='" + courseCode + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", level='" + level + '\'' +
                ", duration=" + duration +
                ", courseType=" + courseType +
                ", courseFormat='" + courseFormat + '\'' +
                ", modulesOffered=" + modulesOffered +
                '}';
    }

    public void addModule(Module module1) {
    }
}

enum ProgramType {
    UNDERGRADUATE,
    POSTGRADUATE
}
