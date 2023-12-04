import java.util.HashMap;
/*To do
 * instance have  to be made in main method
 * Make a default account for each id student and faculty
 * link these accounts with grades qca etc.
 * design the gui
 * set default password as Password or their birthday etc.
 * 
 */

public class LoginDetails {
    private HashMap<Integer, String> studentPasswords = new HashMap<>();
    private HashMap<Integer, Student> students = new HashMap<>();

    public LoginDetails() {
        createStudentAccounts();
    }

   private void createStudentAccounts() {
        // Create student accounts
        Course course1 = new Course("LM121", "Bachelor of Science in Computer Science", "Engineering Dept", "Undergraduate", 4, CourseType.UNDERGRADUATE);
        Student student1 = new Student(1, "StudentName1", "student1@example.com", "Address1", course1);
        // Add module grades to the student
        Module module1 = new Module("M101", "Mathematics", 5, 0, null);
        student1.addModuleGrade(module1, "A");
        
        students.put(1, student1); // Associate student ID with Student instance

        // Set default passwords (based on IDs for demonstration purposes)
        studentPasswords.put(1, "StudentName1"); // Example student password
        // Add more passwords similarly
    }


    public HashMap<Integer, String> getStudentPasswords() {
        return studentPasswords;
    }

    public HashMap<Integer, Student> getStudents() {
        return students;
    }
}
