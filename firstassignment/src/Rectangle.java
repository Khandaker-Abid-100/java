public class Rectangle {
   private int length;
    private     int width;
        Rectangle(){
        }
        Rectangle(int length){
            this.length= length;
        }
    Rectangle(int length,int width){
        this.length= length;
        this.width = width;
    }
    void setLength(int length){
            this.length = length;
    }
    int getLength(){
            return length;
    }

    void setWidth(int width){
        this.width = width;
    }
    int getWidth(){
        return width;
    }
}
