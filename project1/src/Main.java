import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("username = ");
        String username = sc.next();
        System.out.println("password = ");
        String password =sc.next();
        if(readInfo(username,password)){
            System.out.println("authenticated successful");
            while(true){
                System.out.println("1.add student info");
                System.out.println("2.view student info");
                System.out.println("3.search student info by id");
                System.out.println("4.Assign Courses to Student");
                System.out.println("enter your choice");
                int choice = sc.nextInt();
                sc.nextLine();
                switch (choice) {
                    case 1 :
                        addStudentInfo();
                        break;
                        case 2 :
                            viewStudentInfo();
                        break;
                        case 3 :
                            searchStudentInfoById(sc);
                        break; 
                        case 4 :
                            assignCoursesToStudent();
                        break;
                        case 5 :
                            searchAdvisedCourses();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        
                }
                }
            }
        }

    private static void searchAdvisedCourses() {
        try{
            RandomAccessFile ref = new RandomAccessFile("courses.txt","r");
            String line;
            while((line=ref.readLine())!=null){
             String[] arr = line.split(",");
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void assignCoursesToStudent() {
        try{
            RandomAccessFile ref = new RandomAccessFile("courses.txt","rw");
            Scanner sc = new Scanner(System.in);
            System.out.println("enter id and courses");
            String line = sc.nextLine();
            String f = line+",\n";
            ref.seek(ref.length());
            ref.writeBytes(f);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private static void searchStudentInfoById(Scanner sc) {
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

    private static void viewStudentInfo() {
        try{
            RandomAccessFile ref = new RandomAccessFile("student.txt","r");
            String line;
            while((line=ref.readLine())!=null){
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void addStudentInfo(){
Scanner sc = new Scanner(System.in);
        System.out.println("enter id = ");
       int id =  sc.nextInt();
       sc.nextLine();
        System.out.println("enter name = ");
        String name =  sc.nextLine();
        System.out.println("enter program = ");
        String program =  sc.nextLine();
        System.out.println("enter batch = ");
        int batch =  sc.nextInt();
        System.out.println("enter cgpa = ");
        double cgpa =  sc.nextDouble();
        String line = id+","+name+","+program+","+cgpa;
        writeStudentinfo(line);
        Student add = new Student(id,name,batch,program,cgpa);
    }

    private static void writeStudentinfo(String line) {
        try{
            RandomAccessFile ref = new RandomAccessFile("student.txt","rw");
            ref.seek(ref.length());
            ref.writeBytes(line);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    public static void write(){
        try{
            String line = "abid";
            RandomAccessFile ref = new RandomAccessFile("studentInfo.txt", "rw");
            ref.seek(ref.length());
            ref.writeBytes(line);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
    public static boolean readInfo(String name, String password){
        try {
            RandomAccessFile ref = new RandomAccessFile("studentInfo.txt", "r");
            String line;
            while((line=ref.readLine())!=null){
                String[] arr = line.split(",");
                if(arr.length==arr.length && arr[0].equals(name) && arr[1].equals(password)){
                    return true;
                }
            }
        }catch(IOException e){
            e.printStackTrace();
        }
        return false;

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