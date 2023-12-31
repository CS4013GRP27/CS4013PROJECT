/**
 * The ResultCalculator class provides methods to calculate QCA, determine progression, and evaluate grades for students.
 * It offers functionality to calculate QCA for semesters and overall, evaluate grades, and check for progression requirements.
 * 
 * <p>Usage:
 * <ol>
 *    <li>Create an instance of the ResultCalculator class.</li>
 *    <li>Invoke the appropriate method(s) to calculate QCA, check progression, or evaluate grades.</li>
 * </ol>
 * 
 * <p>Note: Ensure module grades are provided correctly to obtain accurate calculations.
 * /

import java.util.List;

public class ResultCalculator {


	//Using Qca formula of Sum of(QPV multiplied by Module Credits) all over Total number of module credits for semester
    public double calculateQcaOneSemester(List<ModuleGrade> moduleGrades) {
        double totalGradePoints = 0.0;
        int totalCredits = 0;

        for (ModuleGrade moduleGrade : moduleGrades) {
            totalGradePoints += convertGradeToQPV(moduleGrade.getGrade()) * moduleGrade.getCreditValue();
            totalCredits += moduleGrade.getCreditValue();
        }

        return totalGradePoints / totalCredits;
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

        if (totalCredits == 0) {
            return 0.0; // Avoid division by zero
        }

        return totalGradePoints / totalCredits;
    }

    public boolean needsToRepeatSemester(List<ModuleGrade> moduleGrades) {//The minimum standards for progression are as follows:
        double qca = calculateQcaOneSemester(moduleGrades);				  //QCA greater than or equal to 2.00
        																  //No deficient grades (i.e., F, N, NG, I)
        if (qca >= 2.0) {
            for (ModuleGrade moduleGrade : moduleGrades) {
                if (moduleGrade.getGrade().equals("F") ||
                    moduleGrade.getGrade().equals("N") ||
                    moduleGrade.getGrade().equals("NG") ||
                    moduleGrade.getGrade().equals("I")) {
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
    
    
    public double calculateResidualQca(List<ModuleGrade> moduleGrades) {
        double totalResidualGradePoints = 0.0;
        int totalCredits = 0;

        for (ModuleGrade moduleGrade : moduleGrades) {
            if (moduleGrade.getGrade().equals("F") ||
                moduleGrade.getGrade().equals("N") ||
                moduleGrade.getGrade().equals("NG") ||
                moduleGrade.getGrade().equals("D1") ||
                moduleGrade.getGrade().equals("D2")) {
                
                totalResidualGradePoints += convertGradeToQPV("C3") * moduleGrade.getCreditValue();
                totalCredits += moduleGrade.getCreditValue();
            } else {
                totalResidualGradePoints += convertGradeToQPV(moduleGrade.getGrade()) * moduleGrade.getCreditValue();
                totalCredits += moduleGrade.getCreditValue();
            }
        }

        if (totalCredits == 0) {
            return 0.0; // Avoid division by zero
        }

        return totalResidualGradePoints / totalCredits;
    }

    public boolean passesSemester(List<ModuleGrade> moduleGrades) {
        double qca = calculateQcaOneSemester(moduleGrades);
        return qca > 2.0; 
    }
    
    public boolean isFailingSemester(List<ModuleGrade> moduleGrades) {
        for (ModuleGrade moduleGrade : moduleGrades) {
            if (isFailingGrade(moduleGrade.getGrade())) {
                return true; 
            }
        }
        return false;
    }

    private boolean isFailingGrade(String grade) {
        return grade.equals("F") || grade.equals("N") || grade.equals("NG");
    }
    
    public boolean isQcaBelowTwo(List<List<ModuleGrade>> allSemesterGrades) {
        double overallQCA = calculateQcaAllSemesters(allSemesterGrades);
        return overallQCA < 2.0;
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
            	return 0;
            case "NG":
            	return 0;
            case "N": 
            	return 0;
            default: 
            	return 0;
        }
    }
}
