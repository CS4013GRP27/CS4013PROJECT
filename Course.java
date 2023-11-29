import java.util.ArrayList;
import java.util.List;


public class Program {
   private String courseCode;
   private String name;
   private String department;
   private String level;
   private int duration;
   private List<ModuleGrade> modulesOffered;
   private ProgramType courseType;
   private String courseFormat;


   public Program(String courseCode, String name, String department, String level, int duration,
       ProgramType programType, String programFormat) {
       this.courseCodeCode = courseCode;
       this.name = name;
       this.department = department;
       this.level = level;
       this.duration = duration;
       this.courseType = courseType;
       this.courseFormat = courseFormat;
       this.modulesOffered = new ArrayList<>();
   }


   public void addModuleGrade(Module module, String grade) {
       this.modulesOffered.add(new ModuleGrade(module, grade));
   }


   public double calculateProgramQCA(ResultsCalculator calculator) {
       return calculator.calculateQCA(modulesOffered);
   }


   public String getProgramCode() {
       return programCode;
   }


   public void setProgramCode(String courseCode) {
       this.courseCode = programCode;
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


   public CourseType getProgramType() {
       return programType;
   }


   public void setCourseType(CourseType courseType) {
       this.programType = programType;
   }


   public String getCourseFormat() {
       return programFormat;
   }


   public void setCourseFormat(String courseFormat) {
       this.programFormat = programFormat;
   }


   @Override
   public String toString() {
       return "Program{" +
               "programCode='" + courseCode + '\'' +
               ", name='" + name + '\'' +
               ", department='" + department + '\'' +
               ", level='" + level + '\'' +
               ", duration=" + duration +
               ", programType=" + courseType +
               ", programFormat='" + courseFormat + '\'' +
               ", modulesOffered=" + modulesOffered +
               '}';
   }
}


enum CourseType {
   UNDERGRADUATE,
   POSTGRADUATE
}
