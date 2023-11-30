import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private int facultyId;
    private String name;
    private List<Module> modulesTaught;
    private Department department;

    public Faculty(int facultyId, String name, Department department) {
        this.facultyId = facultyId;
        this.name = name;
        this.department = department;
        this.modulesTaught = new ArrayList<>();
    }

    public void submitResultsForModules(List<ModuleGrade> moduleGrades) {
        for (ModuleGrade moduleGrade : moduleGrades) {
            modulesTaught.add(moduleGrade.getModule());
        }
    }

    public List<Transcript> lookupTranscripts(List<Student> students) {
        List<Transcript> transcripts = new ArrayList<>();
        for (Student student : students) {
            transcripts.add(student.getTranscript());
        }
        return transcripts;
    }

    public void holdExamBoard(List<Student> students) {
        ExamBoard examBoard = new ExamBoard(1, department, "Spring");
        department.holdExamBoard(examBoard);
    }

    public void assignDepartment(Department department) {
        this.department = department;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Module> getModulesTaught() {
        return modulesTaught;
    }

    public void setModulesTaught(List<Module> modulesTaught) {
        this.modulesTaught = modulesTaught;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
