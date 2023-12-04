import java.util.ArrayList;
import java.util.List;

public class Course {
    private String courseCode;
    private String name;
    private String department;
    private String level;
    private int duration;
    private List<Module> modulesOffered;
    private List<ModuleGrade>moduleGrades;
    private CourseType courseType;
    private List<Student> enrolledStudents;

    public Course(String courseCode, String name, String department, String level, int duration, CourseType courseType) {
        this.courseCode = courseCode;
        this.name = name;
        this.department = department;
        this.level = level;
        this.duration = duration;
        this.courseType = courseType;
        this.modulesOffered = new ArrayList<>();
        this.moduleGrades = new ArrayList<>();
        this.enrolledStudents = new ArrayList<>();
    }

    public void addModuleGrade(Module module, String grade, int creditValue) {
        ModuleGrade moduleGrade = new ModuleGrade(module, grade, creditValue);
        moduleGrades.add(moduleGrade);
    }

    public double calculateSemesterQCA(ResultCalculator calculator) {
        return calculator.calculateQcaOneSemester(moduleGrades);
    }

    public String getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(String courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return name;
    }

    public void setCourseName(String name) {
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

    public List<Module> getModulesOffered() {
        return modulesOffered;
    }

    public void setModulesOffered(List<Module> modulesOffered) {
        this.modulesOffered = modulesOffered;
    }

    public CourseType getCourseType() {
        return courseType;
    }

    public void setCourseType(CourseType courseType) {
        this.courseType = courseType;
    }
    
    public void addModule(Module module) {
        modulesOffered.add(module);
    }
    
    public void removeModule(Module module) {
        modulesOffered.remove(module);
    }
    

    public Module getModuleByCode(String moduleCode) {
        for (Module module : modulesOffered) {
            if (module.getModuleCode().equals(moduleCode)) {
                return module;
            }
        }
        return null; 
    }

    public boolean removeModuleByCode(String moduleCode) {
        Module moduleToRemove = null;
        for (Module module : modulesOffered) {
            if (module.getModuleCode().equals(moduleCode)) {
                moduleToRemove = module;
                break;
            }
        }
        if (moduleToRemove != null) {
            modulesOffered.remove(moduleToRemove);
            return true; 
        }
        return false; 
    }

    public void enrollStudent(Student student) {
        student.setCourse(this); 
        enrolledStudents.add(student);
    }
   
    public List<Student> getStudentsByCourse() {
        return enrolledStudents;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseCode='" + courseCode + '\'' +
                ", name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", level='" + level + '\'' +
                ", duration=" + duration +
                ", courseType=" + courseType +
                ", modulesOffered=" + modulesOffered +
                '}';
    }
}

enum CourseType {
    UNDERGRADUATE,
    POSTGRADUATE
}
