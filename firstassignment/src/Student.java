public class Student {
    private String name;
 private String number;
   private   int roll ;
  private    String program;
  private    int batch;
     Student(){

     }
     Student(String myName,int myRoll,String myNumber){
         name = myName;
         roll = myRoll;
         number = myNumber;
     }
    Student(String myName,int myRoll,String myNumber,String myProgram){
        name = myName;
        roll = myRoll;
        number = myNumber;
        program = myProgram;
    }
    Student(String myName,int myRoll,String myNumber,String myProgram,int myBatch){
        name = myName;
        roll = myRoll;
        number = myNumber;
        program = myProgram;
        batch = myBatch;
    }
void setName(String name){
         this.name=name;
}
 String getName(){
         return name;
 }
    void setRoll(int roll){
        this.roll=roll;
    }
    int getRoll(){
        return roll;
    }
    void setNumber(String number){
        this.number=number;
    }
    String getNumber(){
        return number;
    }
    void setProgram(String program){
        this.program=program;
    }
    String getProgram(){
        return program;
    }
    void setBatch(int batch){
        this.batch=batch;
    }
    int getBatch(){
        return batch;
    }































//    Student()
//    {
//setName("abid");
//    }
//    Student(String myName, int myRoll){
//        name = myName;
//        roll = myRoll;
//    }
//
//    void setName(String name) {
//        this.name = name;
//    }
//    String getName(){
//        return name;
//    }
//
//    void setRoll(int roll) {
//        this.roll = roll;
//    }
//    int getRoll(){
//        return roll;
//    }
//
//    void setNumber(String number) {
//        this.number = number;
//    }
//    String getNumber(){
//        return number;
//    }
//
//    void setProgram(String program) {
//        this.program = program;
//    }
//    String getProgram(){
//        return program;
//    }
//    void setBatch(int batch) {
//        this.batch = batch;
//    }
//    int getBatch(){
//        return batch;
//    }
}
