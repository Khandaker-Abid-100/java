public class Print extends Thread{
    private String lable;
    private int start;
    private int end;

    public Print(String lable, int start, int end) {
        this.lable = lable;
        this.start = start;
        this.end = end;
    }

    public String getLable() {
        return lable;
    }

    public void setLable(String lable) {
        this.lable = lable;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
    @Override
    public  void run(){
        print();
    }
    public void print(){
        for (int i = start;i<=end;i++){
            if (i%2==0){
                System.out.println("Even number"+i);
            } else if (i%2!=0) {
                System.out.println("odd number"+i);
            }
        }
    }
}
