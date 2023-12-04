public class Module {
    private String moduleCode;
    private String title;
    private int credits;
    private String level;
    private String department;

    public Module(String moduleCode, String title, int credits, String level, String department) {
        this.moduleCode = moduleCode;
        this.title = title;
        this.credits = credits;
        this.level = level;
        this.department = department;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public void setModuleCode(String moduleCode) {
        this.moduleCode = moduleCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Module{" +
                "moduleCode='" + moduleCode + '\'' +
                ", title='" + title + '\'' +
                ", credits=" + credits +
                ", level=" + level +
                ", department='" + department + '\'' +
                '}';
    }
}
