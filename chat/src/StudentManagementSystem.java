//public class Main {
//    public static void main(String[] args) {
//        System.out.println("Hello world!");
//    }
//}
import java.io.*;
import java.util.Scanner;

public class StudentManagementSystem {

    private static final String USER_FILE_PATH = "users.txt";
    private static void addUser(String username, String password) {
        try (FileWriter writer = new FileWriter(USER_FILE_PATH, true)) {
            // Append the new username and password to the file
            writer.write(username + "," + password + "\n");
            System.out.println("User added successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
    private static final String STUDENT_FILE_PATH = "students.dat";

    public static void main(String[] args) {
        addUser("newuser", "newpassword123");
        Scanner scanner = new Scanner(System.in);

        // Authentication
        if (!authenticateUser(scanner)) {
            System.out.println("Authentication failed. Exiting...");
            return;
        }

        System.out.println("Authentication successful. Welcome!");

        // Menu
        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Add Student");
            System.out.println("2. Search Student by ID");
            System.out.println("3. Assign Courses to Student");
            System.out.println("4. Search Advised Courses by Student ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addStudent(scanner);
                    break;
                case 2:
                    searchStudentByID(scanner);
                    break;
                case 3:
                    assignCoursesToStudent(scanner);
                    break;
                case 4:
                    searchAdvisedCourses(scanner);
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static boolean authenticateUser(Scanner scanner) {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try (Scanner fileScanner = new Scanner(new File(USER_FILE_PATH))) {
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("User file not found.");
        }
        return false;
    }

    private static void addStudent(Scanner scanner) {
        try (RandomAccessFile file = new RandomAccessFile("STUDENT_FILE_PATH.text", "rw")) {
            // Move pointer to end of file
            file.seek(file.length());

            System.out.print("Enter student ID: ");
            int id = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Enter student name: ");
            String name = scanner.nextLine();
            System.out.print("Enter student program: ");
            String program = scanner.nextLine();
            System.out.print("Enter student batch: ");
            int batch = scanner.nextInt();
            System.out.print("Enter student CGPA: ");
            double cgpa = scanner.nextDouble();

            // Write student details to file
            file.writeInt(id);
            file.writeUTF(name);
            file.writeUTF(program);
            file.writeInt(batch);
            file.writeDouble(cgpa);

            System.out.println("Student added successfully.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void searchStudentByID(Scanner scanner) {
        System.out.print("Enter student ID to search: ");
        int searchID = scanner.nextInt();

        try (RandomAccessFile file = new RandomAccessFile("STUDENT_FILE_PATH.text", "r")) {
            while (file.getFilePointer() < file.length()) {
                int id = file.readInt();
                String name = file.readUTF();
                String program = file.readUTF();
                int batch = file.readInt();
                double cgpa = file.readDouble();

                if (id == searchID) {
                    System.out.println("Student ID: " + id);
                    System.out.println("Name: " + name);
                    System.out.println("Program: " + program);
                    System.out.println("Batch: " + batch);
                    System.out.println("CGPA: " + cgpa);
                    return;
                }
            }
            System.out.println("Student not found.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static void assignCoursesToStudent(Scanner scanner) {
        // Implement course assignment logic here
        System.out.println("Assigning courses to student...");
    }

    private static void searchAdvisedCourses(Scanner scanner) {
        // Implement advised courses search logic here
        System.out.println("Searching advised courses...");
    }
}
