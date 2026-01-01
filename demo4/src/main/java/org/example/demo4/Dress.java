package org.example.demo4;

public class Dress {
    private String name;
    private String type;
    private boolean boosted;
    private String color;
    private double price;
    private String des;
    private String last;
    private String img;
    private String disco;
    public Dress(String name,String type,boolean boosted,String color,double price){
        this.name = name;
        this.type = type;
        this.boosted = boosted;
        this.color = color;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isBoosted() {
        return boosted;
    }

    public String getColor() {
        return color;
    }

    public double getPrice() {
        return price;
    }

    public String getDes() {
        return des;
    }

    public String getLast() {
        return last;
    }

    public String getImg() {
        return img;
    }

    public String getDisco() {
        return disco;
    }
}
