import java.io.*;
import java.util.Scanner;

public class Main {
    //private static final String USER_FILE_PATH = "users.txt";
    private static final String USER_FILE_PATH = "users.txt";

    // Existing code...

    private static void addUser(String username, String password) {
        try (RandomAccessFile file = new RandomAccessFile("user.text", "rw")) {
            // Move pointer to the end of the file
            file.seek(file.length());

            // Write the new username and password to the file
            file.writeBytes(username + "," + password + "\n");
            System.out.println("User added successfully.");
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static final String STUDENT_FILE_PATH = "students.dat";

    public static void main(String[] args) {
       // addUser("abid", "abid");
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
        try (RandomAccessFile file = new RandomAccessFile("user.text", "r")) {
            long fileLength = file.length();
            long pointer = 0;

            while (pointer < fileLength) {
                file.seek(pointer);

                // Read a line from the file
                String line = file.readLine();

                // Convert the line to username and password
                String[] parts = line.split(",");
                String fileUsername = parts[0];
                String filePassword = parts[1];

                // Compare username and password
                String username = "abid";
                String password = "abid";
                if (fileUsername.equals(username) && filePassword.equals(password)) {
                    return true; // Authentication successful
                }

                // Move the pointer to the beginning of the next line
                pointer = file.getFilePointer();
            }
        } catch (FileNotFoundException e) {
            System.out.println("User file not found.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return false; // Authentication failed
    }

    private static boolean authenticateUser(String username, String password) {
        try (RandomAccessFile file = new RandomAccessFile("user.text", "r")) {
            long fileLength = file.length();
            long pointer = 0;

            while (pointer < fileLength) {
                file.seek(pointer);

                // Read a line from the file
                String line = file.readLine();

                // Convert the line to username and password
                String[] parts = line.split(",");
                String fileUsername = parts[0];
                String filePassword = parts[1];

                // Compare username and password
                if (fileUsername.equals(username) && filePassword.equals(password)) {
                    return true; // Authentication successful
                }

                // Move the pointer to the beginning of the next line
                pointer = file.getFilePointer();
            }
        } catch (FileNotFoundException e) {
            System.out.println("User file not found.");
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }

        return false; // Authentication failed
    }
//    private static boolean authenticateUser(Scanner scanner) {
//        System.out.print("Enter username: ");
//        String username = scanner.nextLine();
//        System.out.print("Enter password: ");
//        String password = scanner.nextLine();
//
//        try (Scanner fileScanner = new Scanner(new File("user.text"))) {
//            while (fileScanner.hasNextLine()) {
//                String line = fileScanner.nextLine();
//                String[] parts = line.split(",");
//                if (parts.length == 2 && parts[0].equals(username) && parts[1].equals(password)) {
//                    return true;
//                }
//            }
//        } catch (FileNotFoundException e) {
//            System.out.println("User file not found.");
//        }
//        return false;
//    }

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


//Your task is to create a console application for managing student information.
// The information will be managed only by the admission officer(s). Upon starting
// the project, prompt the user to input their username and password. Validate
// this information from a file. If the provided password is incorrect, display an error
// message and request a reattempt.
//
//Once successfully authenticated, the officer gains access to functionalities such as
// adding and viewing student information. The officer can input details like student ID
// , name, program, batch, password and CGPA. Additionally, the officer can search for
// student information using their ID and view all details except the password.
//
//Likewise, the officer can assign courses to students. A student can take multiple courses.
// The application should have the functionality to search for advised course information
// based on a student's ID. All data, including student information and advised courses,
// must be stored and retrieved from a file.
//
//You need to showcase the project through a screen recording and presentation.
// Also, you have to attach the source code during submission.