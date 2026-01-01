import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

      //  AdmissionOfficer s = new AdmissionOfficer();
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
                System.out.println("5. Exit");

                System.out.print("Enter your choice: ");
                int choice = sc.nextInt();
                sc.nextLine(); // Consume newline character

                switch (choice) {
                    case 1:
                        addStudent();
                        break;
//                    case 2:
//                        viewStudentInformation();
//                        break;
//                    case 3:
//                        searchInformationById(sc);
//                        break;
//                    case 4:
//                        assignCoursesToStudent();
//                        break;
//                    case 5:
//                        searchAdvisedCourses();
//                    case 6:
//                        System.out.println("Exiting...");
//
//                    default:
//                        System.out.println("Invalid choice. Please try again.");
//                }
            }
        }

    }


}
    public static  void write(){
        try{
            //String line = "abid";
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
    private static void addStudent() {
//        try{
//            RandomAccessFile file = new RandomAccessFile("student.text","rw");
//            file.seek(file.length());
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

        // Write student details to file
//            file.writeInt(id);
//            file.writeBytes(name);
//            file.writeBytes(program);
//            file.writeInt(batch);
//            file.writeDouble(cgpa);
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
    }}

