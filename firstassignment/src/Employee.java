public class Employee {
   private String name;
  private   int id;
   private int salary;
    Employee(){
    }
    Employee(String name){
        this.name = name;
    }
    Employee(String name ,int id){
        this.name = name;
        this.id = id;
    }
    Employee(String name ,int id,int salary){
        this.name = name;
        this.id = id;
        this.salary = salary;
    }
    void setName(String name){
        this.name = name;
    }
    String getName(){
        return name;
    }
    void setId(int id){
        this.id = id;
    }
    int getId(){
        return id;
    }
    void setSalary(int salary){
        this.salary = salary;
    }
    int getSalary(){
        return salary ;
    }
}
