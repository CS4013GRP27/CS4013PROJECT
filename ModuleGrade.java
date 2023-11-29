
public class ModuleGrade {
String grade;
int creditValue;
String moduleCode;

	public ModuleGrade(String moduleCode, String grade, int creditValue) {
	this.grade = grade;
	this.creditValue = creditValue;
	this.moduleCode= moduleCode;
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
	
	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}
}
