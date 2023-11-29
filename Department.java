import java.util.ArrayList;
import java.util.List;
 hello 
public class Department {
   private String name;
   private List<Program> programs;
   private List<Faculty> facultyList;
   private List<ExamBoard> examBoards;


   public Department(String name) {
       this.name = name;
       this.programs = new ArrayList<>();
       this.facultyList = new ArrayList<>();
       this.examBoards = new ArrayList<>();
   }


   public void addProgram(Program program) {
       this.programs.add(program);
   }


   public void removeProgram(Program program) {
       this.programs.remove(program);
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
       for (Program program : programs) {
           for (Student student : program.getStudentsEnrolled()) {
               double studentQCA = student.calculateQCA();
               if (studentQCA < 2.0) {
                   studentsNotMeetingStandards.add(student);
               }
           }
       }
       return studentsNotMeetingStandards;
   }




   public String getName() {
       return name;
   }


   public void setName(String name) {
       this.name = name;
   }


   public List<Program> getPrograms() {
       return programs;
   }


   public void setPrograms(List<Program> programs) {
       this.programs = programs;
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
