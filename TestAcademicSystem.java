import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AllClassesTest {

    // Test cases for Module class
    @Test
    public void testModuleConstructor() {
        Module module = new Module("M101", "Mathematics", 5);
        assertEquals("M101", module.getModuleCode());
        assertEquals("Mathematics", module.getTitle());
        assertEquals(5, module.getCredits());
    }

    @Test
    public void testModuleGetterMethods() {
        Module module = new Module("M101", "Mathematics", 5);
        assertEquals("M101", module.getModuleCode());
        assertEquals("Mathematics", module.getTitle());
        assertEquals(5, module.getCredits());
    }

    // Test cases for Course class
    @Test
    public void testCourseConstructor() {
        Course course = new Course("COMP1010", "Programming Concepts", "Computer Science", "Undergraduate", 1);
        assertEquals("COMP1010", course.getCourseCode());
        assertEquals("Programming Concepts", course.getName());
        assertEquals("Computer Science", course.getDepartment());
        assertEquals("Undergraduate", course.getLevel());
        assertEquals(1, course.getDuration());
        assertEquals(0, course.getModules().size()); // Initially no modules added
    }

    @Test
    public void testCourseGetterMethods() {
        Course course = new Course("COMP1010", "Programming Concepts", "Computer Science", "Undergraduate", 1);
        assertEquals("COMP1010", course.getCourseCode());
        assertEquals("Programming Concepts", course.getName());
        assertEquals("Computer Science", course.getDepartment());
        assertEquals("Undergraduate", course.getLevel());
        assertEquals(1, course.getDuration());
    }

    @Test
    public void testAddModuleToCourse() {
        Course course = new Course("COMP1010", "Programming Concepts", "Computer Science", "Undergraduate", 1);
        Module module = new Module("M101", "Mathematics", 5);
        course.addModule(module);
        assertEquals(1, course.getModules().size());
        assertTrue(course.getModules().contains(module));
    }

    @Test
    public void testRemoveModuleFromCourse() {
        Course course = new Course("COMP1010", "Programming Concepts", "Computer Science", "Undergraduate", 1);
        Module module = new Module("M101", "Mathematics", 5);
        course.addModule(module);
        course.removeModule(module);
        assertEquals(0, course.getModules().size());
        assertFalse(course);
    }
}
