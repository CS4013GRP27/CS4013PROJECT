import java.util.ArrayList;
import java.util.List;


public class Program {
   private String programCode;
   private String name;
   private String department;
   private String level;
   private int duration;
   private List<ModuleGrade> modulesOffered;
   private ProgramType programType;
   private String programFormat;


   public Program(String programCode, String name, String department, String level, int duration,
       ProgramType programType, String programFormat) {
       this.programCode = programCode;
       this.name = name;
       this.department = department;
       this.level = level;
       this.duration = duration;
       this.programType = programType;
       this.programFormat = programFormat;
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


   public void setProgramCode(String programCode) {
       this.programCode = programCode;
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


   public ProgramType getProgramType() {
       return programType;
   }


   public void setProgramType(ProgramType programType) {
       this.programType = programType;
   }


   public String getProgramFormat() {
       return programFormat;
   }


   public void setProgramFormat(String programFormat) {
       this.programFormat = programFormat;
   }


   @Override
   public String toString() {
       return "Program{" +
               "programCode='" + programCode + '\'' +
               ", name='" + name + '\'' +
               ", department='" + department + '\'' +
               ", level='" + level + '\'' +
               ", duration=" + duration +
               ", programType=" + programType +
               ", programFormat='" + programFormat + '\'' +
               ", modulesOffered=" + modulesOffered +
               '}';
   }
}


enum ProgramType {
   UNDERGRADUATE,
   POSTGRADUATE
}
