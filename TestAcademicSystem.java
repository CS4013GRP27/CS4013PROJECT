import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TestAcademicSystem {

    private Module module1;
    private Module module2;
    private Module module3;
    private Module module4;
    private Module module5;
    private Program program1;
    private Program program2;
    private Department engineeringDept;
    private Student student1;
    private Student student2;

    @BeforeEach
    void setUp() {
        module1 = new Module("M101", "Mathematics", 5, 0, null);
        module2 = new Module("P201", "Physics", 4, 0, null);
        module3 = new Module("C907", "English", 4, 0, null);
        module4 = new Module("C123", "Irish", 4, 0, null);
        module5 = new Module("C145", "Biology", 4, 0, null);

        program1 = new Program("LM121", "Bachelor of Science in Computer Science", "Engineering Dept", "Undergraduate", 4);
        program1.addModule(module1);
        program1.addModule(module2);
        program1.addModule(module3);
        program1.addModule(module4);
        program1.addModule(module5);

        program2 = new Program("LM122", "Bachelor of Arts in History", "Humanities Dept", "Undergraduate", 4);
        program2.addModule(module1);
        program2.addModule(module2);
        program2.addModule(module3);
        program2.addModule(module4);
        program2.addModule(module5);

        engineeringDept = new Department("Engineering Department");
        engineeringDept.addProgram(program1);
        engineeringDept.addProgram(program2);

        student1 = new Student(1001, "Billy Leenane", "123@gmail.com", "123 Town street", program1);
        student1.addModuleGrade(module1, "A1");
        student1.addModuleGrade(module2, "B2");
        student1.addModuleGrade(module3, "C3");
        student1.addModuleGrade(module4, "B3");
        student1.addModuleGrade(module5, "B2");

        student2 = new Student(1002, "Ainsley Alabi", "Ainsley@gmail.com", "123 City St", program2);
        student2.addModuleGrade(module1, "A2");
        student2.addModuleGrade(module2, "B3");
        student2.addModuleGrade(module3, "C1");
        student2.addModuleGrade(module4, "A1");
        student2.addModuleGrade(module5, "B1");
    }

    @Test
    void testCalculateAverageQCAAndRepeatingModules() {
        double averageQCAStudent1 = student1.calculateQCA();
        assertEquals(3.28, averageQCAStudent1, 0.01);

        if (averageQCAStudent1 < 2.0) {
            assertTrue(false, "Student 1 needs to repeat the year");
        }

        List<ModuleGrade> student1Grades = student1.getModules();
        for (ModuleGrade grade : student1Grades) {
            if (grade.getGrade().equals("D1") || grade.getGrade().equals("D2")) {
                assertTrue(false, "Student 1 needs to repeat a module");
                break;
            }
        }

        double averageQCAStudent2 = student2.calculateQCA();
        assertEquals(3.24, averageQCAStudent2, 0.01);

        if (averageQCAStudent2 < 2.0) {
            assertTrue(false, "Student 2 needs to repeat the year");
        }

        List<ModuleGrade> student2Grades = student2.getModules();
        for (ModuleGrade grade : student2Grades) {
            if (grade.getGrade().equals("D1") || grade.getGrade().equals("D2")) {
                assertTrue(false, "Student 2 needs to repeat a module");
                break;
            }
        }
    }


}
