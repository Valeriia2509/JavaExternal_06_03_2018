package Task1;

import java.util.Scanner;

public class Ship extends Vehicle {
    private int passengers;
    private String port;

    public Ship(int price, int speed, int year, String port, int pas, int x, int y){
        super(price,speed,year,x,y);
        this.port=port;
        this.passengers=pas;
    }

    public void setVehicleParameters(Scanner sc){
        super.setVehicleParameters(sc);
        int passengers=-1;

        while (passengers<0){
            System.out.println("Введите количество пассажиров:");
            passengers=sc.nextInt();
        }
        this.passengers=passengers;

        System.out.println("Введите название порта:");
        port=sc.next();
    }

    public void getVehicleParameters(){
        super.getVehicleParameters();
        System.out.print(", port: " + port  +
                ", passengers: " + passengers);
    }

    public String vehicleType(){
        return "Ship";
    }

    @Override
    public String toString() {
        return super.toString()+
                ", port: " + port  +
                ", passengers: " + passengers;
    }
}
