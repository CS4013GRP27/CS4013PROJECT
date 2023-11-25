import java.util.ArrayList;
import java.util.List;

public class ExamBoard {
    private int boardId;
    private Department department;
    private String semester;
    private List<Student> reviewedStudents;
    private List<ModuleGrade> submittedGrades;

    public ExamBoard(int boardId, Department department, String semester) {
        this.boardId = boardId;
        this.department = department;
        this.semester = semester;
        this.reviewedStudents = new ArrayList<>();
        this.submittedGrades = new ArrayList<>();
    }

    public void reviewStudentProgression() {
        List<Student> students = department.identifyStudentsNotMeetingStandards();
        for (Student student : students) {
        }
        reviewedStudents.addAll(students);
    }

    public void submitGrades(List<ModuleGrade> grades) {
        submittedGrades.addAll(grades);
    }


    public List<Student> getReviewedStudents() {
        return reviewedStudents;
    }

    public void setReviewedStudents(List<Student> reviewedStudents) {
        this.reviewedStudents = reviewedStudents;
    }

    public List<ModuleGrade> getSubmittedGrades() {
        return submittedGrades;
    }

    public void setSubmittedGrades(List<ModuleGrade> submittedGrades) {
        this.submittedGrades = submittedGrades;
    }

    public int getBoardId() {
        return boardId;
    }

    public void setBoardId(int boardId) {
        this.boardId = boardId;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public String getSemester() {
        return semester;
    }

    public void setSemester(String semester) {
        this.semester = semester;
    }
}
