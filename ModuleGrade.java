public class ModuleGrade {
    private String grade;
    private int creditValue;
    private Module module;

    public ModuleGrade(Module module, String grade, int creditValue) {
        this.module = module;
        this.grade = grade;
        this.creditValue = creditValue;
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

    public Module getModuleCode() {
        return moduleCode;
    }

    public void setModule(String moduleCode) {
        this.moduleCode = moduleCode;
    }
}
