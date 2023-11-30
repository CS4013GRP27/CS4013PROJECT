import java.util.List;

public class TestAcademicSystem {

    public static void main(String[] args) {
        Module module1 = new Module("M101", "Mathematics", 5, 0, null);
        Module module2 = new Module("P201", "Physics", 4, 0, null);

        Program program1 = new Program("P101", "Physics 101", 4, 0, null);
        program1.addModule(module1);
        program1.addModule(module2);

        Department engineeringDept = new Department("Engineering Department");
        engineeringDept.addProgram(program1);

        Student student1 = new Student(1001, "Billy Leenane", "123@gmail.com", "123 Town street", program1);
        student1.addModuleGrade(module1, "A1");
        student1.addModuleGrade(module2, "B2");

        TranscriptManager transcriptManager = new TranscriptManager();

        transcriptManager.generateTranscript(student1);

        System.out.println("Transcript for student1:");
        transcriptManager.printTranscript(student1.getStudentId());

        transcriptManager.updateTranscript(student1, module1, "A2");

        System.out.println("\nUpdated transcript for student1:");
        transcriptManager.printTranscript(student1.getStudentId());

        Transcript ownTranscript = transcriptManager.viewOwnTranscript(student1);
        System.out.println("\nStudent1's own transcript:");
        if (ownTranscript != null) {
            ownTranscript.printTranscript();
        }

        Transcript facultyTranscript = transcriptManager.provideTranscriptToFaculty(student1.getStudentId());
        System.out.println("\nFaculty transcript for student1:");
        if (facultyTranscript != null) {
            facultyTranscript.printTranscript();
        }

        List<Student> students = engineeringDept.identifyStudentsNotMeetingStandards();
        transcriptManager.holdExamBoard(engineeringDept, students);

        
    }
}
