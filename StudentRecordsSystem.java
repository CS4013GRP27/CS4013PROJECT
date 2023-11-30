public class StudentRecordsSystem {

    public static void main(String[] args) {
        // Create Modules
        Module module1 = new Module("M101", "Mathematics", 5);
        Module module2 = new Module("P201", "Physics", 4);
        Module module3 = new Module("C907", "English", 4);
        Module module4 = new Module("C123", "Irish", 4);
        Module module5 = new Module("C145", "Biology", 4);

        // Create Programs
        Program program1 = new Program("LM121", "Bachelor of Science in Computer Science", "Engineering Dept", "Undergraduate", 4);
        program1.addModule(module1);
        program1.addModule(module2);
        program1.addModule(module3);
        program1.addModule(module4);
        program1.addModule(module5);

        Program program2 = new Program("LM122", "Bachelor of Arts in History", "Humanities Dept", "Undergraduate", 4);
        program2.addModule(module1);
        program2.addModule(module2);
        program2.addModule(module3);
        program2.addModule(module4);
        program2.addModule(module5);

        // Create Department
        Department engineeringDept = new Department("Engineering Department");
        engineeringDept.addProgram(program1);
        engineeringDept.addProgram(program2);

        // Create Students
        Student student1 = new Student(1001, "Billy Leenane", "123@gmail.com", "123 Town street", program1);
        student1.addModuleGrade(module1, "A1");
        student1.addModuleGrade(module2, "B2");
        student1.addModuleGrade(module3, "C3");
        student1.addModuleGrade(module4, "B3");
        student1.addModuleGrade(module5, "B2");

        Student student2 = new Student(1002, "Ainsley Alabi", "Ainsley@gmail.com", "123 City St", program2);
        student2.addModuleGrade(module1, "A2");
        student2.addModuleGrade(module2, "B2");
        student2.addModuleGrade(module3, "C1");
        student2.addModuleGrade(module4, "A1");
        student2.addModuleGrade(module5, "B1");

        Student student3 = new Student(1003, "Eoghan O'Donovan", "Eoghan@gmail.com", "1223 United St", program1);
        student3.addModuleGrade(module1, "A1");
        student3.addModuleGrade(module2, "B2");
        student3.addModuleGrade(module3, "C3");
        student3.addModuleGrade(module4, "A1");
        student3.addModuleGrade(module5, "B2");

        // Create Academic System
        AcademicSystem academicSystem = new AcademicSystem();
        academicSystem.addDepartment(engineeringDept);
        academicSystem.addStudent(student1);
        academicSystem.addStudent(student2);
        academicSystem.addStudent(student3);

        // Example operations
        System.out.println("Students in Physics Department:");
        List<Student> physicsStudents = academicSystem.getStudentsByProgram(program1);
        for (Student student : physicsStudents) {
            System.out.println(student.getName());
        }

        System.out.println("\nOverall Average QCA: " + academicSystem.calculateOverallAverageQCA());
    }
}
