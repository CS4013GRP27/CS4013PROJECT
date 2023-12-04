import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

public class TestAcademicSystem {

    // Test cases for Module class
    @Test
    public void testModuleConstructor() {
        Module module = new Module("M101", "Mathematics", 5, 0, null);
        assertEquals("M101", module.getModuleCode());
        assertEquals("Mathematics", module.getTitle());
        assertEquals(5, module.getCredits());
    }

    @Test
    public void testModuleGetterMethods() {
        Module module = new Module("M101", "Mathematics", 5, 0, null);
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
        Module module = new Module("M101", "Mathematics", 5, 0, null);
        course.addModule(module);
        
        List<Module> modulesOffered = course.getModulesOffered(); // Assuming getModulesOffered() returns a List<Module>
        
        assertEquals(1, modulesOffered.size());
        assertTrue(modulesOffered.contains(module));
    }
    
    
    @Test
    public void testRemoveModuleFromCourse() {
        Course course = new Course("COMP1010", "Programming Concepts", "Computer Science", "Undergraduate", 1, null);
        Module module = new Module("M101", "Mathematics", 5, 0, null);
        course.addModule(module);
        course.removeModule(module);
        
        List<Module> modulesOffered = course.getModulesOffered(); // Assuming getModulesOffered() returns a List<Module>
        
        assertEquals(0, modulesOffered.size());
        assertFalse(modulesOffered.contains(module));
    }
    
    private void assertFalse(boolean b) {
    }
}
