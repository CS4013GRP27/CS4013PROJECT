import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class CSVReader {
    public static void main(String[] args) {
        String studentCsvFile = "C:\\Users\\School\\Downloads\\Student.csv";
        String courseCsvFile = "C:\\Users\\School\\Downloads\\course.csv";
        String csvFile = "C:\\Users\\School\\Downloads\\modules.csv"; 
        String delimiter = ",";
       
        List<Course> courses = readCourseDataFromCSV(courseCsvFile, ",");
        Map<String, Course> courseMap = createCourseMap(courses);
        List<Module> modules = readModuleDataFromCSV(csvFile, delimiter);
        for (Module module : modules) {
            System.out.println("Module Code: " + module.getModuleCode());
            System.out.println("Title: " + module.getTitle());
            System.out.println("Credits: " + module.getCredits());
            System.out.println("Level: " + module.getLevel());
            System.out.println("Department: " + module.getDepartment());
            System.out.println("----------------------------------");
        }

        List<Student> students = readStudentDataFromCSV(studentCsvFile, ",", courseMap);
        for (Student student : students) {
            System.out.println("Student ID: " + student.getStudentId());
            System.out.println("Name: " + student.getName());
            System.out.println("Email: " + student.getEmail());
            Course studentCourse = student.getCourse();
            if (studentCourse != null) {
                System.out.println("Course: " + studentCourse.getCourseName());
                System.out.println("Course Code: " + studentCourse.getCourseCode());
                System.out.println("Department: " + studentCourse.getDepartment());
                System.out.println("Level: " + studentCourse.getLevel());
                System.out.println("Duration: " + studentCourse.getDuration() + " years");
            } else {
                System.out.println("Course details not found for this student.");
            }
            System.out.println("Address: " + student.getAddress());
            System.out.println("--------------------------------");
        }
    
    }

    public static List<Student> readStudentDataFromCSV(String csvFile, String delimiter, Map<String, Course> courseMap) {
        List<Student> students = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                StringTokenizer tokenizer = new StringTokenizer(line, delimiter);
                List<String> columns = new ArrayList<>();

                while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken();
                    columns.add(token);
                }

                if (columns.size() >= 5) {
                    int studentId = Integer.parseInt(columns.get(0));
                    String name = columns.get(1);
                    String email = columns.get(2);
                    String address = columns.get(3);
                    String courseName = columns.get(4);

                    Course studentCourse = courseMap.get(courseName);
                    if (studentCourse != null) {
                        Student student = new Student(studentId, name, email, address, studentCourse);
                        students.add(student);
                    } else {
                        System.err.println("Course not found for student: " + name);
                    }
                } else {
                    System.err.println("Incomplete data in CSV row: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return students;
    }

    public static List<Course> readCourseDataFromCSV(String csvFile, String delimiter) {
        List<Course> courses = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                StringTokenizer tokenizer = new StringTokenizer(line, delimiter);
                List<String> columns = new ArrayList<>();

                while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken();
                    columns.add(token);
                }

                if (columns.size() >= 5) {
                    String courseCode = columns.get(0);
                    String courseName = columns.get(1);
                    String department = columns.get(2);
                    String level = columns.get(3);
                    int duration = Integer.parseInt(columns.get(4));

                    Course course = new Course(courseCode, courseName, department, level, duration);
                    courses.add(course);
                } else {
                    System.err.println("Incomplete data in CSV row: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return courses;
    }

    public static Map<String, Course> createCourseMap(List<Course> courses) {
        Map<String, Course> courseMap = new HashMap<>();

        for (Course course : courses) {
            courseMap.put(course.getCourseName(), course);
        }

        return courseMap;
    }
    
    public static List<Module> readModuleDataFromCSV(String csvFile, String delimiter) {
        List<Module> modules = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            String line;
            boolean firstLine = true;

            while ((line = br.readLine()) != null) {
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                StringTokenizer tokenizer = new StringTokenizer(line, delimiter);
                List<String> columns = new ArrayList<>();

                while (tokenizer.hasMoreTokens()) {
                    String token = tokenizer.nextToken();
                    columns.add(token);
                }

                if (columns.size() >= 5) {
                    String moduleCode = columns.get(0);
                    String moduleName = columns.get(1);
                    int credits = Integer.parseInt(columns.get(2));
                    String level = columns.get(3);
                    String department = columns.get(4);

                    Module module = new Module(moduleCode, moduleName, credits, level, department);
                    modules.add(module);
                } else {
                    System.err.println("Incomplete data in CSV row: " + line);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return modules;
    }
}
