public class First {
    public static void main(String[] args) {
        //student data
Student s1 = new Student("abid",100,"01923345105");
        Student s2 = new Student("momin",101,"01923342035","cse");
        Student s3 = new Student("rafi",98,"01923342037","EEE",61);
        System.out.println(s1.getName()+" "+s1.getRoll()+" "+s1.getNumber());
        System.out.println(s2.getName()+" "+s2.getRoll()+" "+s2.getNumber()+" "+s2.getProgram());
        System.out.println(s3.getName()+" "+s3.getRoll()+" "+s3.getNumber()+" "+s3.getProgram()+" "+s3.getBatch());
        //car data
        Car c1 = new Car("TATA");
        Car c2 = new Car("BMW","a558");
        Car c3 = new Car("AUDI","b657",1999);
        System.out.println(c1.getBrand());
        System.out.println(c2.getBrand()+" "+c2.getModel());
        System.out.println(c3.getBrand()+" "+c3.getModel()+" "+ c3.getYear());
        //circle data
        Circle cir1 = new Circle(5);
        System.out.println(cir1.getRadius());
        //emloyee data
            Employee e1 = new Employee("abid");
            Employee e2 = new Employee("momin",101);
            Employee e3 = new Employee("rafi",98,30000);
            System.out.println(e1.getName());
            System.out.println(e2.getName()+" "+e2.getId());
            System.out.println(e3.getName()+" "+e3.getId()+" "+e3.getSalary());
            //rectangle data
        Rectangle r1 = new Rectangle(5);
        Rectangle r2 = new Rectangle(7,10);
        System.out.println(r1.getLength());
        System.out.println(r2.getLength()+" "+r2.getWidth());

    }
}



//*. Write default constructor
//*. Write at least 3 parameterized constructor for each class
//*. Encapsulate all the attributes
//*. Use setter methods to create the same objects
//*. Use necessary getter methods to print those objects

















//======assignment5=======

//sc.setName("abid");
//        sc.setRoll(100);
//        sc.setBatch(61);
//        sc.setNumber("01923345105");
//        sc.setProgram("cse");
//        System.out.println(sc.getName()+"  "+sc.getRoll()+"  "+sc.getNumber()+"  "+sc.getProgram()+"  "+sc.getBatch());

//==================================================================================
//===========assignment4==========
//Rectangle sc = new Rectangle();
//sc.length = 50;
//sc.width = 20;
//Employee sc1 =new Employee();
//sc1.id = 100;
//sc1.name = "abid";
//sc1.salary = 200000000;
//Circle sc2 = new Circle();
//sc2.radius = 5;
//Car sc3 = new Car();
//sc3.brand = "tata";
//sc3.model = "A1";
//sc3.year = 2024;
//Student sc4 = new Student();
//sc4.name = "abid";
//sc4.number = "01923345105";
//sc4.roll = 100;
//sc4.batch = 61;
//sc4.program = "cse";
//        System.out.println(sc.length+" " +sc.width);
//        System.out.println(sc1.name +" id="+sc1.id+" Salary = "+sc1.salary);


//==============assignment3========
//=========1st problem=========
//System.out.println("enter two integers:");
//Scanner sc=new Scanner(System.in);
//double a = sc.nextInt();
//double b = sc.nextInt();
//        if (b==0)
//        {
//double sum=a+b;
//double sum1=a*b;
//            System.out.println(sum +" "+sum1 +" undefined");
//        }
//                else {
//double sum=a+b;
//double sum1=a*b;
//double sum2 = a / b;
//            System.out.println(sum +" "+sum1 +" "+sum2 +" ");
//        }

//=========2nd problem=============
//System.out.println("Enter a char :");
//
//Scanner sc = new Scanner(System.in);
//char latter=sc.next().charAt(0);
//        if(latter=='a'||latter=='e'||latter=='i'||latter=='o'||latter=='u')
//        {
//        System.out.println("vowel");
//        }
//                else {
//                System.out.println("conso");
//        }

//+++++++++++new++++++
//
//        System.out.println("Enter a string :");
//
//Scanner sc = new Scanner(System.in);
//String str = sc.nextLine();
//        int v=0,c=0;
//str=str.toUpperCase();
//for(int i=0;i<str.length();i++) {
//char ch=str.charAt(i);
//    if (ch == 'A' || ch == 'E' || ch == 'I' || ch == 'O' || ch == 'U') {
//v++;
//        }
//        else {
//
//c++;
//        }
//        }
//        System.out.println("vowel = "+v+"  conso = "+c);




//========3rd problem=======
//        int i,sum=0;
//        for (i=2;i<=100;i=i+2)
//        {
//            sum=sum+i;
//            System.out.println(i);
//        }
//        System.out.println(sum);


//==========4th problem============
//System.out.println("enter farehheight:");
//Scanner sc=new Scanner(System.in);
//double fer=sc.nextInt();
//double cel=(fer-32)*5/9;
//String celci=String.format("%.2f",cel);
//        System.out.println(celci);

//==========5th problem=========
//        System.out.println("Enter three numbers: ");
//        Scanner sc = new Scanner(System.in);
//        int a = sc.nextInt();
//        int b = sc.nextInt();
//        int c = sc.nextInt();
//        if (a>b && a>c)
//        {
//            System.out.println(a);
//
//        }
//        if (b>a && b>c)
//        {
//            System.out.println(b);
//
//        }
//        if (c>b && c>a)
//        {
//            System.out.println(c);
//
//        }


