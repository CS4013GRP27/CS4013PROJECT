import java.util.List;

public class StudentRecordsSystem {

    public static void main(String[] args) {
        // Creating the modules 
        Module module1 = new Module("M101", "Mathematics", 5, 0, null);
        Module module2 = new Module("P201", "Physics", 4, 0, null);
        Module module3 = new Module("C907", "English", 4, 0, null);
        Module module4 = new Module("C123", "Irish", 4, 0, null);
        Module module5 = new Module("C145", "Biology", 4, 0, null);

        // Creating the programs 
        Course course1 = new Course("LM121", "Bachelor of Science in Computer Science", "Engineering Dept", "Undergraduate", 4, null, null);
        course1.addModule(module1);
        course1.addModule(module2);
        course1.addModule(module3);
        course1.addModule(module4);
        course1.addModule(module5);

        Course course2 = new Course("LM122", "Bachelor of Arts in History", "Humanities Dept", "Undergraduate", 4, null, null);
        course2.addModule(module1);
        course2.addModule(module2);
        course2.addModule(module3);
        course2.addModule(module4);
        course2.addModule(module5);

        // Creating the department 
        Department engineeringDept = new Department("Engineering Department");
        engineeringDept.addCourse(course1);
        engineeringDept.addCourse(course2);

        // Creating the students 
        Student student1 = new Student(1001, "Billy Leenane", "123@gmail.com", "123 Town street", course1);
        student1.addModuleGrade(module1, "A1");
        student1.addModuleGrade(module2, "B2");
        student1.addModuleGrade(module3, "C3");
        student1.addModuleGrade(module4, "B3");
        student1.addModuleGrade(module5, "B2");

        Student student2 = new Student(1002, "Ainsley Alabi", "Ainsley@gmail.com", "123 City St", course2);
        student2.addModuleGrade(module1, "A2");
        student2.addModuleGrade(module2, "B2");
        student2.addModuleGrade(module3, "C1");
        student2.addModuleGrade(module4, "A1");
        student2.addModuleGrade(module5, "B1");

        Student student3 = new Student(1003, "Eoghan O'Donovan", "Eoghan@gmail.com", "1223 United St", course1);
        student3.addModuleGrade(module1, "A1");
        student3.addModuleGrade(module2, "B2");
        student3.addModuleGrade(module3, "C3");
        student3.addModuleGrade(module4, "A1");
        student3.addModuleGrade(module5, "B2");

        // Creating academic system 
        AcademicSystem academicSystem = new AcademicSystem();
        academicSystem.addDepartment(engineeringDept);
        academicSystem.addStudent(student1);
        academicSystem.addStudent(student2);
        academicSystem.addStudent(student3);

        // Example of the operations
        System.out.println("Students in Physics Department:");
        List<Student> physicsStudents = academicSystem.getStudentsByProgram(course1);
        for (Student student : physicsStudents) {
            System.out.println(student.getName());
        }

        System.out.println("\nOverall Average QCA: " + academicSystem.calculateOverallAverageQCA());
    }
}
