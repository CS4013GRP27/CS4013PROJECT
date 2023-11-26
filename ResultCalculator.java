import java.util.List;

public class ResultCalculator {

    public double calculateQCA(List<String> grades) {
        double totalGradePoints = 0.0;

        for (String grade : grades) {
            totalGradePoints += convertGradeToPoint(grade);
        }

        return totalGradePoints / grades.size();
    }

    public boolean needsToRepeatModule(String grade) {
        return grade.equals("F") || grade.equals("NG");
    }

    public boolean needsToRepeatYear(List<String> grades) {
        double qca = calculateQCA(grades);

        if (qca < 2.0) {
            boolean hasD1 = grades.contains("D1");
            boolean hasD2 = grades.contains("D2");

            if (hasD1 && hasD2) {
                return false; 
            } else {
                return true; 
            }
        }

        return false; 
    }

    public boolean passesYear(List<String> grades) {
        double qca = calculateQCA(grades);
        return qca > 2.0; 
    }

    private double convertGradeToPoint(String grade) {
        switch (grade) {
            case "A1": return 4.0;
            case "A2": return 3.6;
            case "B1": return 3.2;
            case "B2": return 3.0;
            case "B3": return 2.8;
            case "C1": return 2.6;
            case "C2": return 2.4;
            case "C3": return 2.0;
            case "D1": return 1.6;
            case "D2": return 1.2;
            case "F": return 0;
            case "NG": return 0;
            default: return 0;
        }
    }
}
