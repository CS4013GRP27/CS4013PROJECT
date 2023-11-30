import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import java.util.List;

public class TestAcademicSystem {

    private AcademicSystem academicSystem;
    private Department engineeringDept;
    private Course course1;
    private Course course2;
    private Module module1;
    private Module module2;
    private Module module3;
    private Module module4;
    private Module module5;
    private Student student1;
    private Student student2;
    private Student student3;

    @BeforeEach
    public void setUp() {
        module1 = new Module("M101", "Mathematics", 5);
        module2 = new Module("P201", "Physics", 4);
        module3 = new Module("C907", "English", 4);
        module4 = new Module("C123", "Irish", 4);
        module5 = new Module("C145", "Biology", 4);

        course1 = new Course("LM121", "Bachelor of Science in Computer Science", "Engineering Dept", "Undergraduate", 4);
        course1.addModule(module1);
        course1.addModule(module2);
        course1.addModule(module3);
        course1.addModule(module4);
        course1.addModule(module5);

        course2 = new Course("LM122", "Bachelor of Arts in History", "Humanities Dept", "Undergraduate", 4);
        course2.addModule(module1);
        course2.addModule(module2);
        course2.addModule(module3);
        course2.addModule(module4);
        course2.addModule(module5);

        // Create Department
        engineeringDept = new Department("Engineering Department");
        engineeringDept.addProgram(course1);
        engineeringDept.addProgram(course2);

        student1 = new Student(1001, "Billy Leenane", "123@gmail.com", "123 Town street", course1);
        student1.addModuleGrade(module1, "A1");
        student1.addModuleGrade(module2, "B2");
        student1.addModuleGrade(module3, "C3");
        student1.addModuleGrade(module4, "B3");
        student1.addModuleGrade(module5, "B2");


        academicSystem = new AcademicSystem();
        academicSystem.addDepartment(engineeringDept);
        academicSystem.addStudent(student1);
        academicSystem.addStudent(student2);
        academicSystem.addStudent(student3);
    }

    @Test
    public void testCalculateOverallAverageQCA() {
        double averageQCAStudent1 = academicSystem.calculateOverallAverageQCA(student1);
        double averageQCAStudent2 = academicSystem.calculateOverallAverageQCA(student2);
        double averageQCAStudent3 = academicSystem.calculateOverallAverageQCA(student3);

        assertEquals(3.28, averageQCAStudent1, 0.01);
        assertEquals(3.24, averageQCAStudent2, 0.01);
        assertEquals(3.0, averageQCAStudent3, 0.01);
    }

    @Test
    public void testStudentProgression() {
        assertTrue(academicSystem.checkStudentProgression(student1));
        assertTrue(academicSystem.checkStudentProgression(student2));
        assertFalse(academicSystem.checkStudentProgression(student3));
    }

    @Test
    public void testRepeatModules() {
        assertFalse(academicSystem.checkForRepeatModules(student1));
        assertFalse(academicSystem.checkForRepeatModules(student2));
        assertTrue(academicSystem.checkForRepeatModules(student3));
    }

   }



