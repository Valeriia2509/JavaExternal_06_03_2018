package Task1;

import java.util.Scanner;

public class Plane extends Vehicle {
    private int hight;
    private int passengers;
    public Plane(int price, int speed, int year, int hig, int pas, int x, int y){
        super(price,speed,year,x,y);
        this.hight=hig;
        this.passengers=pas;
    }

    public int getHight() {
        return hight;
    }

    public void setHight(int high) {
        this.hight = hight;
    }

    public int getPassengers() {
        return passengers;
    }

    public void setPassengers(int passengers) {
        this.passengers = passengers;
    }

    public void getVehicleParameters(){
        super.getVehicleParameters();
        System.out.print(", high: " + hight  +
                ", passengers: " + passengers);
    }

    public void setVehicleParameters(Scanner sc){
        super.setVehicleParameters(sc);
        int hight=-1;
        int passengers=-1;

        while (passengers<0){
            System.out.println("Введите количество пассажиров:");
            passengers=sc.nextInt();
        }
        this.passengers=passengers;

        while (hight<0){
            System.out.println("Введите высоту:");
            hight=sc.nextInt();
        }
        this.hight=hight;
    }

    public String vehicleType(){
        return "Plane";
    }

    @Override
    public String toString() {
        return super.toString()+
                ", high: " + hight  +
                ", passengers: " + passengers;
    }
}
