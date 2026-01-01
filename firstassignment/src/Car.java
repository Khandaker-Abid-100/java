public class Car {
   private String brand;
   private String model;
   private     int year;
       Car(){

       }
       Car(String carBrand){
           brand = carBrand;
       }
    Car(String carBrand,String carMode){
        brand = carBrand;
        model = carMode;
    }
    Car(String carBrand,String carMode,int carYear){
        brand = carBrand;
        model = carMode;
        year = carYear;
    }
    void setBrand(String brand){
           this.brand = brand;

    }
    String getBrand(){
           return brand;
    }

    void setModel(String model){
        this.model = model;

    }
    String getModel(){
        return model;
    }

    void setYear(int year){
        this.year = year;

    }
    int getYear(){
        return year;
    }
}
