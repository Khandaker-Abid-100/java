import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        HashMap<Integer, Double> employeeData = new HashMap<>();
        employeeData.put(101,50000.00);
        employeeData.put(102,60000.00);
        employeeData.put(103,70000.00);
        employeeData.put(104,80000.00);
        employeeData.put(105,90000.00);
        for (int id : employeeData.keySet()){
            System.out.println("ID = "+id +" salary = "+ employeeData.get(id));
        }
        double av = average(employeeData);
        System.out.println("average salary = "+av);

    }
    public static double average(HashMap<Integer,Double> employeeData){
        double total = 0.0;
        for (double totals:employeeData.values()){
            total+= totals;
        }
        return total/ employeeData.size();
    }
}
//
//*. Create a HashMap named employeeData to store employee IDs (keys) and their
// corresponding salary amount (values).
//        *. Add at least 5 employee records to the employeeData HashMap. Ensure that
//        each employee ID is unique.
//*. Print the employee id and corresponding salary using for-each loop.
//        *. Implement a method to find the average salary in the HashMap.




































//{
//ArrayList<Integer> numbers = new ArrayList<>();
//        for (int i=1;i<=10;i++){
//        numbers.add(i);
//        }
//                System.out.println("array :"+numbers);
//int sum = calculatesum(numbers);
//        System.out.println("sum of array is = "+sum);
//int maximum = max(numbers);
//        System.out.println("maximum number = "+maximum);
//int min = min(numbers);
//        System.out.println("maximum number = "+min);
//double ave = av(numbers);
//        System.out.println("average = "+ave);
//    }
//public static  int calculatesum(ArrayList<Integer> numbers){
//    int sum = 0;
//    for (int num:numbers){
//        sum+=num;
//    }
//    return sum;
//}
//public static  int max(ArrayList<Integer> numbers){
//    int max=0;
//    for(int num:numbers){
//        if(num > max){
//            max = num;
//        }
//    }
//    return max;
//}
//public static  int min(ArrayList<Integer> numbers){
//    int min=numbers.get(0);
//    for(int num:numbers){
//        if(num < min){
//            min = num;
//        }
//    }
//    return min;
//}
//public static  double av(ArrayList<Integer> numbers){
//    double sum = calculatesum(numbers);
//    return sum/numbers.size();
//}
//}