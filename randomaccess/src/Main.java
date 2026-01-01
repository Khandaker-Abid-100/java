import java.io.*;

 class StudentManagement {

    // Method to write student information to file
    public static void writeStudentInfo(String studentInfo) {
        try (RandomAccessFile file = new RandomAccessFile("student_info.txt", "rw")) {
            file.seek(file.length());
            file.writeBytes(studentInfo + "\n");
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read student information from file
    public static String readStudentInfo() {
        StringBuilder studentData = new StringBuilder();
        try (RandomAccessFile file = new RandomAccessFile("student_info.txt", "r")) {
            String line;
            while ((line = file.readLine()) != null) {
                studentData.append(line).append("\n");
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return studentData.toString();
    }

    // Method to write advised courses information to file
    public static void writeAdvisedCourses(String studentId, String advisedCourses) {
        try (RandomAccessFile file = new RandomAccessFile("advised_courses.txt", "rw")) {
            file.seek(file.length());
            file.writeBytes(studentId + ":" + advisedCourses + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Method to read advised courses information from file
    public static String readAdvisedCourses() {
        StringBuilder advisedCoursesData = new StringBuilder();
        try (RandomAccessFile file = new RandomAccessFile("advised_courses.txt", "r")) {
            String line;
            while ((line = file.readLine()) != null) {
                advisedCoursesData.append(line).append("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return advisedCoursesData.toString();
    }

    // Method to search for advised courses by student ID
    public static String searchByStudentId(String studentId) {
        StringBuilder result = new StringBuilder();
        try (RandomAccessFile file = new RandomAccessFile("advised_courses.txt", "r")) {
            String line;
            while ((line = file.readLine()) != null) {
                if (line.startsWith(studentId)) {
                    result.append(line.substring(line.indexOf(":") + 1)).append("\n");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    // Main method
    public static void main(String[] args) {
        // Example usage
        writeStudentInfo("1,John,Doe,Computer Science,2023,3.8");
        writeStudentInfo("2,Jane,Smith,Electrical Engineering,2022,3.9");

        writeAdvisedCourses("1", "CS101,CS102,CS103");
        writeAdvisedCourses("2", "EE101,EE102");

        System.out.println("Student Information:");
        System.out.println(readStudentInfo());

        System.out.println("Advised Courses Information:");
        System.out.println(readAdvisedCourses());

        System.out.println("Search Advised Courses for Student ID 1:");
        System.out.println(searchByStudentId("1"));
    }
}