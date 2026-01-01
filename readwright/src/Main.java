import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

           String line = "akash";
       // wri(line);
        try{
            RandomAccessFile r = new RandomAccessFile("student.text","rw");
            r.seek(r.length());
            r.writeBytes(line+"\n");
        }catch(FileNotFoundException e){
            e.printStackTrace();

        }catch(IOException e){
            e.printStackTrace();
        }
 try{
     RandomAccessFile ri = new RandomAccessFile("student.text","r");
     String fine;
     while((fine=ri.readLine())!=null){
     System.out.println(fine);
     }
 }catch (FileNotFoundException e){
e.printStackTrace();
 }catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public static void wri(String line)
    {

    }

}