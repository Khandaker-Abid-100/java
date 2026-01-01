import java.io.*;
import java.util.*;

  class Student {
     String id;
     String name;
     String program;
     int batch;
     double cgpa;
    // Add any additional fields as needed

    public Student(String id, String name, String program, int batch, double cgpa) {
        this.id = id;
        this.name = name;
        this.program = program;
        this.batch = batch;
        this.cgpa = cgpa;
    }

    // Add getters and setters as needed
}

class Course {
    private String courseId;
    private String courseName;
    // Add any additional fields as needed

    public Course(String courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    // Add getters and setters as needed
}

class AdmissionOfficer {
     String username;
     String password;

    public AdmissionOfficer(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public boolean authenticate(String inputUsername, String inputPassword) {
        return username.equals(inputUsername) && password.equals(inputPassword);
    }
}

public class StudentManagementSystem {
    private static final String DATA_FILE = "data.txt";
    private static List<Student> students = new ArrayList<>();
    private static List<Course> courses = new ArrayList<>();
    private static AdmissionOfficer officer;

    public static void main(String[] args) {
        loadData();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        officer = authenticate(username, password);

        if (officer != null) {
            System.out.println("Authentication successful.");

            while (true) {
                System.out.println("\n1. Add Student");
                System.out.println("2. View Student Information");
                System.out.println("3. Assign Courses to Student");
                System.out.println("4. View Advised Courses for Student");
                System.out.println("5. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();
                scanner.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        viewStudentInformation();
                        break;
                    case 3:
                        assignCoursesToStudent();
                        break;
                    case 4:
                        viewAdvisedCoursesForStudent();
                        break;
                    case 5:
                        saveData();
                        System.out.println("Exiting...");
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        } else {
            System.out.println("Authentication failed. Exiting...");
        }
    }

    private static AdmissionOfficer authenticate(String username, String password) {
        try (Scanner fileScanner = new Scanner(new File(DATA_FILE))) {
            String storedUsername = fileScanner.nextLine().trim();
            String storedPassword = fileScanner.nextLine().trim();
            if (username.equals(storedUsername) && password.equals(storedPassword)) {
                return new AdmissionOfficer(username, password);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private static void loadData() {
        try (Scanner fileScanner = new Scanner(new File(DATA_FILE))) {
            // Skip first two lines which contain officer username and password
            fileScanner.nextLine();
            fileScanner.nextLine();

            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length >= 5) {
                    String id = parts[0].trim();
                    String name = parts[1].trim();
                    String program = parts[2].trim();
                    int batch = Integer.parseInt(parts[3].trim());
                    double cgpa = Double.parseDouble(parts[4].trim());
                    students.add(new Student(id, name, program, batch, cgpa));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Data file not found. Starting with empty data.");
        }
    }

    private static void saveData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter(DATA_FILE))) {
            writer.println(officer.username);
            writer.println(officer.password);
            for (Student student : students) {
                writer.printf("%s,%s,%s,%d,%.2f%n", student.id, student.name, student.program,
                writer.printf("%s,%s,%s,%d,%.2f%n", student.id, student.name, student.program,
                        student.batch, student.cgpa));
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void addStudent() {
        // Implement adding student functionality
    }

    private static void viewStudentInformation() {
        // Implement viewing student information functionality
    }

    private static void assignCoursesToStudent() {
        // Implement assigning courses to student functionality
    }

    private static void viewAdvisedCoursesForStudent() {
        // Implement viewing advised courses for student functionality
    }
}
