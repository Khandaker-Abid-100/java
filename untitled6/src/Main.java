    //return result.toString();
    import java.io.*;
    import java.util.Scanner;
    import java.io.IOException;
    import java.io.RandomAccessFile;

    public class Main {
        // Main method
        public static void main(String[] args) {
            // Example usage
            Scanner sc = new Scanner(System.in);

            writeStudentInfo(sc.nextLine());
            System.out.println("Student Information:");
            readStudentInfo();

            // writeStudentInfo("6,riaz,Smith,Electrical Engineering,2022,3.9");

            writeAdvisedCourses(sc.next(), sc.nextLine());
            //writeAdvisedCourses("2", "EE101,EE102");

//            System.out.println("Student Information:");
//            readStudentInfo();

            System.out.println("Advised Courses Information:");
            readAdvisedCourses();

            System.out.println("Search Advised Courses for Student ID ");
            searchByStudentId(sc.next());
        }


//class StudentManagement {

        // Method to write student information to file
        public static void writeStudentInfo(String studentInfo) {
            try {
                RandomAccessFile file = new RandomAccessFile("student_info.txt", "rw");
                file.seek(file.length());
                file.writeBytes(studentInfo + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Method to read student information from file
        public static void readStudentInfo() {
            //  StringBuilder studentData = new StringBuilder();
            try {
                RandomAccessFile file = new RandomAccessFile("student_info.txt", "r");
                String line;
                while ((line = file.readLine()) != null) {
                    System.out.println(line);
                    //        studentData.append(line).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            //return studentData.toString();

        }

        // Method to write advised courses information to file
        public static void writeAdvisedCourses(String studentId, String advisedCourses) {
            try {
                RandomAccessFile file = new RandomAccessFile("advised_courses.txt", "rw");
                file.seek(file.length());
                file.writeBytes(studentId + ":" + advisedCourses + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        // Method to read advised courses information from file
        public static void readAdvisedCourses() {
            //StringBuilder advisedCoursesData = new StringBuilder();
            try {
                RandomAccessFile file = new RandomAccessFile("advised_courses.txt", "r");
                String line;
                while ((line = file.readLine()) != null) {
                    System.out.println(line);
                    //      advisedCoursesData.append(line).append("\n");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            // return advisedCoursesData.toString();
        }

        // Method to search for advised courses by student ID
        public static void searchByStudentId(String studentId) {
            //StringBuilder result = new StringBuilder();
            try {
                RandomAccessFile file = new RandomAccessFile("advised_courses.txt", "r");
                String line;
                while ((line = file.readLine()) != null) {
                    if (line.startsWith(studentId)) {
                        System.out.println(line);
                        //result.append(line.substring(line.indexOf(":") + 1)).append("\n");
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }