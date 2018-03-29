package Task1;

import java.util.Scanner;

public abstract class Vehicle {
    private int x;
    private int y;
    private int price;
    private int speed;
    private int year;

    public Vehicle(int price, int speed, int year, int x, int y) {
        this.x=x;
        this.y=y;
        this.price = price;
        this.speed = speed;
        this.year = year;
    }

    abstract public String vehicleType();

    public int getPrice() {
        return price;
    }

    public int getSpeed() {
        return speed;
    }

    public int getYear() {
        return year;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void getVehicleCoordinates(){
        System.out.println(vehicleType()+" "+" coordinates: " + x +" " + y);
    }

    public void getVehicleParameters(){
        System.out.print(vehicleType()+" price: " + price +
                ", speed: " + speed +
                ", year: " + year);
    }

    public void setVehicleParameters(Scanner sc){
        int price=-1;
        int speed=-1;
        int year=-1;

        while (price<0){
            System.out.println("Введите цену:");
            price=sc.nextInt();
        }
        while (speed<0){
            System.out.println("Введите скорость:");
            speed=sc.nextInt();
        }
        while (year<0){
            System.out.println("Введите год:");
            year=sc.nextInt();
        }
        this.price=price;
        this.speed=speed;
        this.year=year;
    }

    public void setVehicleCoordinates(Scanner sc){
        int x=-100;
        int y=-190;

        while ((x<-90)||(x>90)) {
            System.out.println("Введите широту:");
            x = sc.nextInt();
        }
        while ((y<-180)||(y>180)) {
            System.out.println("Введите долготу:");
            y = sc.nextInt();
        }

        setX(x);
        setY(y);
    }

    @Override
    public String toString() {
        return
               vehicleType()+ " coordinates: " + x +
                " " + y +
                ", price: " + price +
                ", speed: " + speed +
                ", year: " + year;
    }
}
