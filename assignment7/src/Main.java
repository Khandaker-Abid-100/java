import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Input student information = ");
        writhStudenInfo(sc.nextLine());
        System.out.println("student information :");
        readStudentInfo();
        System.out.println("enter id and courses = ");
        advisedCourses(sc.next(),sc.nextLine());
        System.out.println("id and courses are : ");
        readIdCcourses();
        System.out.println("enter id to find courses");
        searchid(sc.next());
    }
    public static void writhStudenInfo(String line){
        try {
            RandomAccessFile r = new RandomAccessFile("studentInfo.text", "rw");
            r.seek(r.length());
            r.writeBytes(line  +"\n");
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void readStudentInfo(){
     try {
         RandomAccessFile r = new RandomAccessFile("studentInfo.text", "r");
         String fine;
         while((fine=r.readLine()) != null){
             System.out.println(fine);
         }
     }catch (FileNotFoundException e){
         e.printStackTrace();
     }catch (IOException e) {
         e.printStackTrace();
     }

    }
    public static void advisedCourses(String ID,String courses){
        try {
            RandomAccessFile r = new RandomAccessFile("adviceCourse.text", "rw");
            r.seek(r.length());
            r.writeBytes(ID  +" : "+ courses+"\n");
        }catch(FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void readIdCcourses(){
        try {
            RandomAccessFile r = new RandomAccessFile("advicecourse.text", "r");
            String fine;
            while((fine=r.readLine()) != null){
                System.out.println(fine);
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void searchid(String Id){
        try{
            RandomAccessFile r = new RandomAccessFile("advicecourse.text", "r");
            String fine;
            while((fine=r.readLine()) != null){
                if (fine.startsWith(Id)){
                    System.out.println(fine);
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch(IOException e ){
            e.printStackTrace();
        }
    }
}
//1. Write a console program to manage student information by writing and
// reading data to/from a file. Each line in the file presents a student record
// containing their ID, name, password, program, batch, and CGPA.
//
//        2. Create functionality to handle advised courses information for students by
//        writing and reading data to/from a file. Each record in the file should contain a
//        student ID paired with the corresponding course code.
//
//        3. Add functionality to search by student ID to retrieve the corresponding advised
//        course information from the stored file records.
