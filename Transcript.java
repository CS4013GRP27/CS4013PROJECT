import java.io.*;
import java.util.*;


public class Transcript {

    private Student student;
    private Map<Module, String> moduleGrades;

    public Transcript(Student student) {
        this.student = student;
        this.moduleGrades = new HashMap<>();
    }

    public void generateTranscript() {
        System.out.println("Generating Transcript for Student: " + student.getName());
        System.out.println("Transcript Details:");
        for (Map.Entry<Module, String> entry : moduleGrades.entrySet()) {
            System.out.println(entry.getKey().getTitle() + " - Grade: " + entry.getValue());
        }
        System.out.println("Transcript generated successfully.");
    }

    public void printTranscript() {
        generateTranscript(); // Prints the transcript details
    }

    public void updateModuleGrade(Module module, String grade) {
        moduleGrades.put(module, grade);
    }

    // Other methods like finalizeGrades(), getGradeForModule(), etc.

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Map<Module, String> getModuleGrades() {
        return moduleGrades;
    }

    public void setModuleGrades(Map<Module, String> moduleGrades) {
        this.moduleGrades = moduleGrades;
    }

    public double calculateQCA() {
        ResultCalculator resultCalculator = new ResultCalculator();
        List<ModuleGrade> moduleGradesList = new ArrayList<>();

        // Convert the stored module grades to ModuleGrade objects
        for (Map.Entry<Module, String> entry : moduleGrades.entrySet()) {
            ModuleGrade moduleGrade = new ModuleGrade(entry.getKey(), entry.getValue());
            moduleGradesList.add(moduleGrade);
        }

        return resultCalculator.calculateQcaOneSemester(moduleGradesList);
    }
    
    public void writeToCSV(String csvFile) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(csvFile))) {
            for (Map.Entry<Module, String> entry : moduleGrades.entrySet()) {
                String csvRecord = entry.getKey().getModuleCode() + "," +
                        entry.getKey().getTitle() + "," +
                        entry.getKey().getCredits() + "," +
                        entry.getValue();
                bw.write(csvRecord);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void readFromCSV(String csvFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
                if (data.length == 4) {
                    Module module = new Module(data[0], data[1], Integer.parseInt(data[2]), 0, null);
                    moduleGrades.put(module, data[3]);
                }
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }
    }
}
