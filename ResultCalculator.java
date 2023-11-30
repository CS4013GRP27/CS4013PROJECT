import java.util.List;

public class ResultCalculator {

    public double calculateQcaOneSemester(List<ModuleGrade> moduleGrades) {
        double totalGradePoints = 0.0;
        int totalCredits = 0;

        for (ModuleGrade moduleGrade : moduleGrades) {
            totalGradePoints += convertGradeToQPV(moduleGrade.getGrade()) * moduleGrade.getCreditValue();
            totalCredits += moduleGrade.getCreditValue();
        }

        return calculateQCA(totalGradePoints, totalCredits);
    }

    public double calculateQcaAllSemesters(List<List<ModuleGrade>> allSemesterGrades) {
        double totalGradePoints = 0.0;
        int totalCredits = 0;

        for (List<ModuleGrade> semesterGrades : allSemesterGrades) {
            double semesterGradePoints = 0.0;
            int semesterCredits = 0;

            for (ModuleGrade moduleGrade : semesterGrades) {
                semesterGradePoints += convertGradeToQPV(moduleGrade.getGrade()) * moduleGrade.getCreditValue();
                semesterCredits += moduleGrade.getCreditValue();
            }

            totalGradePoints += semesterGradePoints;
            totalCredits += semesterCredits;
        }

        return calculateQCA(totalGradePoints, totalCredits);
    }

    private double calculateQCA(double totalGradePoints, int totalCredits) {
        if (totalCredits == 0) {
            return 0.0; // Avoid division by zero
        }
        return totalGradePoints / totalCredits;
    }

    public boolean needsToRepeatModule(String grade) {
        return grade.equals("F") || grade.equals("NG");
    }

    public boolean needsToRepeatSemester(List<ModuleGrade> moduleGrades) {
        double qca = calculateQcaOneSemester(moduleGrades);
        if (qca >= 2.0) {
            for (ModuleGrade moduleGrade : moduleGrades) {
                if (moduleGrade.getGrade().equals("F") || moduleGrade.getGrade().equals("N") ||
                        moduleGrade.getGrade().equals("NG") || moduleGrade.getGrade().equals("I")) {
                    return false; // Deficient grade found, cannot progress
                }
                if (moduleGrade.getGrade().equals("D1") || moduleGrade.getGrade().equals("D2")) {
                    return true; // "D1" or "D2" grade found, can progress with sufficient QCA
                }
            }
            return true; // Fits requirements
        }
        return false; // QCA less than 2.00, cannot progress
    }

    public boolean passesSemester(List<String> grades) {
        double qca = calculateQcaOneSemester(grades);
        return qca > 2.0;
    }

    public double calculateResidualQca(List<ModuleGrade> moduleGrades) {
        double totalResidualGradePoints = 0.0;
        int totalCredits = 0;

        for (ModuleGrade moduleGrade : moduleGrades) {
            if (moduleGrade.getGrade().equals("F") || moduleGrade.getGrade().equals("N") ||
                    moduleGrade.getGrade().equals("NG") || moduleGrade.getGrade().equals("D1") ||
                    moduleGrade.getGrade().equals("D2")) {
                totalResidualGradePoints += convertGradeToQPV("C3") * moduleGrade.getCreditValue();
            } else {
                totalResidualGradePoints += convertGradeToQPV(moduleGrade.getGrade()) * moduleGrade.getCreditValue();
            }
            totalCredits += moduleGrade.getCreditValue();
        }

        return calculateQCA(totalResidualGradePoints, totalCredits);
    }

    private double convertGradeToQPV(String grade) {
        switch (grade) {
            case "A1":
                return 4.0;
            case "A2":
                return 3.6;
            case "B1":
                return 3.2;
            case "B2":
                return 3.0;
            case "B3":
                return 2.8;
            case "C1":
                return 2.6;
            case "C2":
                return 2.4;
            case "C3":
                return 2.0;
            case "D1":
                return 1.6;
            case "D2":
                return 1.2;
            case "F":
            case "NG":
            case "N":
                return 0;
            default:
                return 0;
        }
    }
}
