import java.util.List;

public class TestAcademicSystem {

    public static void main(String[] args) {
        // Creating modules, programs, and a department
        Module module1 = new Module("M101", "Mathematics", 5, 0, null);
        Module module2 = new Module("P201", "Physics", 4, 0, null);
        // ... create other modules

        Program program1 = new Program("P101", "Physics 101", 4, 0, null);
        program1.addModule(module1);
        program1.addModule(module2);
        // ... add other modules to programs

        Department engineeringDept = new Department("Engineering Department");
        engineeringDept.addProgram(program1);
        // ... add other programs to the department

        // Creating students
        Student student1 = new Student(1001, "Billy Leenane", "123@gmail.com", "123 Town street", program1);
        student1.addModuleGrade(module1, "A1");
        student1.addModuleGrade(module2, "B2");
        // ... add grades for other modules

        // Creating a TranscriptManager
        TranscriptManager transcriptManager = new TranscriptManager();

        // Generating transcripts for students
        transcriptManager.generateTranscript(student1);

        // Printing a transcript
        System.out.println("Transcript for student1:");
        transcriptManager.printTranscript(student1.getStudentId());

        // Updating a module grade
        transcriptManager.updateTranscript(student1, module1, "A2");

        // Printing the updated transcript
        System.out.println("\nUpdated transcript for student1:");
        transcriptManager.printTranscript(student1.getStudentId());

        // View own transcript
        Transcript ownTranscript = transcriptManager.viewOwnTranscript(student1);
        System.out.println("\nStudent1's own transcript:");
        if (ownTranscript != null) {
            ownTranscript.printTranscript();
        }

        // Provide transcript to faculty
        Transcript facultyTranscript = transcriptManager.provideTranscriptToFaculty(student1.getStudentId());
        System.out.println("\nFaculty transcript for student1:");
        if (facultyTranscript != null) {
            facultyTranscript.printTranscript();
        }

        // Example operations for holding exam board and submitting results
        List<Student> students = engineeringDept.identifyStudentsNotMeetingStandards();
        transcriptManager.holdExamBoard(engineeringDept, students);

        // Assuming moduleGrades is a list of ModuleGrade objects to submit
        
    }
}
