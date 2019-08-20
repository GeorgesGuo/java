package com.guo;

public class Car {
    private String brand;
    private double price;
    //计算周长 springEL
    private String tryPrimeter;

   public Car(){

   }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getTryPrimeter() {
        return tryPrimeter;
    }

    public void setTryPrimeter(String tryPrimeter) {
        this.tryPrimeter = tryPrimeter;
    }

    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", price=" + price +
                ", tryPrimeter='" + tryPrimeter + '\'' +
                '}';
    }
}
