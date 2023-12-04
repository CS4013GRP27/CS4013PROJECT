import java.util.ArrayList;
import java.util.List;

public class Department {
    private String name;
    private List<Course> courses;
    private List<Faculty> facultyList;
    private List<ExamBoard> examBoards;

    public Department(String name) {
        this.name = name;
        this.courses = new ArrayList<>();
        this.facultyList = new ArrayList<>();
        this.examBoards = new ArrayList<>();
    }

    public void addCourse(Course course) {
        this.courses.add(course);
    }

    public void removeCourse(Course course) {
        this.courses.remove(course);
    }

    public void addFaculty(Faculty faculty) {
        this.facultyList.add(faculty);
    }

    public void removeFaculty(Faculty faculty) {
        this.facultyList.remove(faculty);
    }

    public void holdExamBoard(ExamBoard examBoard) {
        this.examBoards.add(examBoard);
        examBoard.reviewStudentProgression();
    }

    public List<Student> identifyStudentsNotMeetingStandards() {
        List<Student> studentsNotMeetingStandards = new ArrayList<>();
        return studentsNotMeetingStandards;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Course> getCourses() {
        return courses;
    }

    public void setCourses(List<Course> programs) {
        this.courses = programs;
    }

    public List<Faculty> getFacultyList() {
        return facultyList;
    }

    public void setFacultyList(List<Faculty> facultyList) {
        this.facultyList = facultyList;
    }

    public List<ExamBoard> getExamBoards() {
        return examBoards;
    }

    public void setExamBoards(List<ExamBoard> examBoards) {
        this.examBoards = examBoards;
    }
}
