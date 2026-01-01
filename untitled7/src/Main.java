import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("enter student Info");
        studentInfo(s.nextLine());
        System.out.println("student Info are");
        readInfo();
        System.out.println("enter id and courses ");
        adviceIdcourses(s.next(),s.nextLine());
        System.out.println("Id and courses are");
        readIdcourses();
        System.out.println("enter id to find courser");
        searchId(s.next());
    }
    public static void studentInfo(String s){
        try{
        RandomAccessFile u = new RandomAccessFile("studentInfo.text","rw");
        u.seek(u.length());
        u.writeBytes(s);
        }catch(FileNotFoundException e ){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }

    }
    public static void readInfo(){
        try{
            RandomAccessFile u = new RandomAccessFile("studentInfo.text","r");
          String line;
          while((line=u.readLine())!=null){
              System.out.println(line);
          }
        }catch(FileNotFoundException e ){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void adviceIdcourses(String id,String courses){
        try{
            RandomAccessFile u = new RandomAccessFile("advicedcourses.text","rw");
            u.seek(u.length());
            u.writeBytes(id+":"+courses+"\n");
        }catch(FileNotFoundException e ){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void readIdcourses(){

        try{
            RandomAccessFile u = new RandomAccessFile("advicedcourses.text","r");
            String line;
            while((line=u.readLine())!=null){
                System.out.println(line);
            }
        }catch(FileNotFoundException e ){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public static void searchId(String id){

        try{
            RandomAccessFile u = new RandomAccessFile("advicedcourses.text","r");
            String line;
            while((line=u.readLine())!=null){
                if (line.startsWith(id)){
                    System.out.println(line);
                }
            }
        }catch(FileNotFoundException e ){
            e.printStackTrace();
        }catch(IOException e){
            e.printStackTrace();
        }
    }
}