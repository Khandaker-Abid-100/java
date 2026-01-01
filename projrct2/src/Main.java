import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        AdmissionOfficer s = new AdmissionOfficer();
        Scanner sc = new Scanner(System.in);
        System.out.println("username : ");
        String u = sc.next();

        System.out.println("password : ");
        String v = sc.next();

        if(readoff(u,v)){
            System.out.println("Authentication successful.");

            while (true) {
                System.out.println("\n1. Add Student");
                System.out.println("2. View Student Information");
                System.out.println("3. search Information By Id");
                System.out.println("4. Assign Courses to Student");
                System.out.println("5. search Advised Courses");
                System.out.println("6. Exit");

                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
                    case 2:
                        viewStudentInformation();
                        break;
                    case 3:
                        searchInformationById(sc);
                        break;
                    case 4:
                        assignCoursesToStudent();
                        break;
                    case 5:
                        searchAdvisedCourses();
                    case 6:
                        System.out.println("Exiting...");

                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }

    }
public static  void write(){
    try{
           //  String line = ",ab";
            RandomAccessFile rf = new RandomAccessFile("off.text","rw");
            rf.seek(rf.length());
            //rf.writeBytes(line);
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
}
    public static boolean readoff(String inputUsername, String inputPassword) {
        try{

            RandomAccessFile rf = new RandomAccessFile("off.text","r");
            String line;
            while ((line=rf.readLine())!=null){
                String[] arr = line.split(",");
                if(arr.length==arr.length&& arr[0].equals(inputUsername)&&arr[1].equals(inputPassword)){
                    return true;
                }
            }


        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

        return false;
    }

    private static void searchAdvisedCourses() {
        try{
            RandomAccessFile r = new RandomAccessFile("courses.text","r");
            String line;
            while ((line=r.readLine()) != null){
                String[] arr = line.split(",");
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void searchInformationById(Scanner sc) {
        System.out.print("Enter student ID to search: ");
        int searchID = sc.nextInt();

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
                    //  return;
                }else{
                    System.out.println("Student not found.");
                }
            }

        } catch (IOException e) {
e.printStackTrace();        }
    }



    private static void assignCoursesToStudent() {
        try{
            RandomAccessFile r = new RandomAccessFile("courses.text","rw");
            Scanner sc = new Scanner(System.in);
            System.out.println("enter id and courses");
            String line = sc.nextLine();
            String f = line+",\n";
            r.seek(r.length());
            r.writeBytes(f);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void viewStudentInformation() {
try {
    RandomAccessFile ref = new RandomAccessFile("student.text", "r");

    String line;
    while ((line=ref.readLine())!=null){
        System.out.println(line);
    }


}catch(FileNotFoundException e){
    e.printStackTrace();
}catch(IOException e){
    e.printStackTrace();
}


    }

    private static void addStudent() {

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter student ID: ");
            int id = sc.nextInt();
            sc.nextLine(); // Consume newline
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            System.out.print("Enter student program: ");
            String program = sc.nextLine();
            System.out.print("Enter student batch: ");
            int batch = sc.nextInt();
            System.out.print("Enter student CGPA: ");
            double cgpa = sc.nextDouble();
String line = id+","+batch+","+name+","+program+","+cgpa;
writeStudentInfo(line);
Student add = new Student(id,batch,name,program,cgpa);
            System.out.println("Student added successfully.");

    }
    public static void writeStudentInfo(String line){
        try{RandomAccessFile ref = new RandomAccessFile("student.text","rw");
            ref.seek(ref.length());
            ref.writeBytes(line);
    }catch (IOException e){
            e.printStackTrace();
        }
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