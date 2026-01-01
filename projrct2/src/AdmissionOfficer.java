import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class AdmissionOfficer {

        String username;
        String password;
//try{
//    String line = "hello";
//        RandomAccessFile rf = new RandomAccessFile("off.text","r");
//        rf.seek(rf.length());
//        rf.writeBytes(line);
//    }catch(FileNotFoundException e){
//    e.printStackTrace();
//    }catch(IOException e){
//    e.printStackTrace();
//    }

        public boolean authenticate(String inputUsername, String inputPassword) {
            return username.equals(inputUsername) && password.equals(inputPassword);
        }
    }


