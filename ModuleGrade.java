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

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }
}
