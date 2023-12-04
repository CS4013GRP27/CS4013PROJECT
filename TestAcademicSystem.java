import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class TestAcademicSystem {

    // Test cases for Module class
    @Test
    public void testModuleConstructor() {
        Module module = new Module("M101", "Mathematics", 5, "Underg", null);
        assertEquals("M101", module.getModuleCode());
        assertEquals("Mathematics", module.getTitle());
        assertEquals(5, module.getCredits());
    }

    @Test
    public void testModuleGetterMethods() {
        Module module = new Module("M101", "Mathematics", 5, "Postgraduate", null);
        assertEquals("M101", module.getModuleCode());
        assertEquals("Mathematics", module.getTitle());
        assertEquals(5, module.getCredits());
    }

    
    @Test
    public void testCourseConstructor() {
        Course course = new Course("COMP1010", "Programming Concepts", "Computer Science", "Undergraduate", 1, null);
        assertEquals("COMP1010", course.getCourseCode());
        assertEquals("Programming Concepts", course.getCourseName());
        assertEquals("Computer Science", course.getDepartment());
        assertEquals("Undergraduate", course.getLevel());
        assertEquals(1, course.getDuration());
        assertEquals(0, course.getModulesOffered().size()); // Initially no modules added
    }

    

    @Test
    public void testAddModuleToCourse() {
        Course course = new Course("COMP1010", "Programming Concepts", "Computer Science", "Undergraduate", 1, null);
        Module module = new Module("M101", "Mathematics", 5, "Postgraduate", null);
        course.addModule(module);
        
        List<Module> modulesOffered = course.getModulesOffered(); // Assuming getModulesOffered() returns a List<Module>
        
        assertEquals(1, modulesOffered.size());
        assertTrue(modulesOffered.contains(module));
    }
    
    
    @Test
    public void testRemoveModuleFromCourse() {
        Course course = new Course("COMP1010", "Programming Concepts", "Computer Science", "Undergraduate", 1, null);
        Module module = new Module("M101", "Mathematics", 5, "Postgraduate", null);
        course.addModule(module);
        course.removeModule(module);
        
        List<Module> modulesOffered = course.getModulesOffered(); // Assuming getModulesOffered() returns a List<Module>
        
        assertEquals(0, modulesOffered.size());
        assertFalse(modulesOffered.contains(module));
    }
    
    @Test
    public void testCalculateQcaOneSemester() {
        ResultCalculator calculator = new ResultCalculator();

        // Create Module instances
        Module module1 = new Module("M101", "Mathematics", 5, "Postgraduate", null);
        Module module2 = new Module("P201", "Physics", 4, "Undergraduate", null);
        Module module3 = new Module("C907", "English", 4, "Postgraduate", null);

        ModuleGrade grade1 = new ModuleGrade(module1, "A1", 5);
        ModuleGrade grade2 = new ModuleGrade(module2, "B2", 4);
        ModuleGrade grade3 = new ModuleGrade(module3, "C3", 6);

        List<ModuleGrade> moduleGrades = new ArrayList<>();
        moduleGrades.add(grade1);
        moduleGrades.add(grade2);
        moduleGrades.add(grade3);

        double expectedQCA = (4.0 * 5 + 3.0 * 4 + 2.0 * 6) / (5 + 4 + 6);

        assertEquals(expectedQCA, calculator.calculateQcaOneSemester(moduleGrades));
    }
    void assertFalse(boolean b) {
    }
}
