public class Student {
    int id,batch;
    String name,program;
    String password;
    double cgpa;
    public Student(){

    }
    public Student(int id,int batch,String name,String program,double cgpa){
        this.id = id;
        this.name = name;
        this.cgpa = cgpa;
        this.program = program;
        this.batch = batch;
    }
}
