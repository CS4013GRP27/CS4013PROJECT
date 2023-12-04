import java.util.HashMap;


public class LoginDetails {
    private HashMap<Integer, String> studentPasswords = new HashMap<>();
    private HashMap<Integer, String> facultyPasswords = new HashMap<>();
    private HashMap<Integer, String> departmentPasswords = new HashMap<>();

    private HashMap<Integer, Student> students = new HashMap<>();
    private HashMap<Integer, Faculty> faculties = new HashMap<>();
    private HashMap<Integer, Department> departments = new HashMap<>();

    public LoginDetails() {
        createDefaultAccounts();
    }

    private void createDefaultAccounts() {
        // Create default student accounts
        Course course1 = new Course("LM121", "Bachelor of Science in Computer Science", "Engineering Dept", "Undergraduate", 4, CourseType.UNDERGRADUATE);
        Student student1 = new Student(1, "StudentName1", "student1@example.com", "Address1", course1);
        Module module1 = new Module("M101", "Mathematics", 5, "Undergraduate", null);
        student1.addModuleGrade(module1, "A");
        students.put(1, student1);
        studentPasswords.put(1, "StudentPassword1");

        // Create default faculty accounts
        Department department2 = new Department("DeptName2");
        Faculty faculty1 = new Faculty(101, "FacultyName1", department2);
        faculties.put(101, faculty1);
        facultyPasswords.put(101, "FacultyPassword1");

        // Create default department accounts
        Department department1 = new Department("DeptName1");
        departments.put(201, department1);
        departmentPasswords.put(201, "DepartmentPassword1");
    }

    public String loginUser(int id, String password) {
        if (studentPasswords.containsKey(id) && studentPasswords.get(id).equals(password)) {
            return "student";
        } else if (facultyPasswords.containsKey(id) && facultyPasswords.get(id).equals(password)) {
            return "faculty";
        } else if (departmentPasswords.containsKey(id) && departmentPasswords.get(id).equals(password)) {
            return "department";
        } else {
            return "invalid";
        }
    }

    public HashMap<Integer, Student> getStudents() {
        return students;
    }

    public HashMap<Integer, Faculty> getFaculties() {
        return faculties;
    }

    public HashMap<Integer, Department> getDepartments() {
        return departments;
    }
}
