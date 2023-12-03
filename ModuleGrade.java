public class ModuleGrade {
    private String grade;
    private int creditValue;
    private Module module;
    private String moduleCode;

    public ModuleGrade(Module module, String grade, int creditValue) {
        this.module = module;
        this.grade = grade;
        this.creditValue = creditValue;
    }

    public ModuleGrade(Module module2, String grade2) {
    }

    public ModuleGrade(String moduleCode2, String grade2, int credits) {
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getCreditValue() {
        return creditValue;
    }

    public void setCreditValue(int creditValue) {
        this.creditValue = creditValue;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModule(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public Module getModule() {
        return null;
    }
}
