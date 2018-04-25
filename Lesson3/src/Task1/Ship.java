package Task1;

import java.util.Scanner;

public class Ship extends Vehicle implements ISwim{
    private int passengers;
    private String port;
    private static String type="SHIP";

    public Ship(int x, int y, String port, int price, int speed, int year, int pas){
        super(x, y, price, speed, year);
        this.port=port;
        this.passengers=pas;
    }

    public static class Engine{
        private static String engine="винтовой двигатель";

        public static String vehicleEngine(){
            return type+" "+engine;
        }
    }

    class BodyShape extends Vehicle.BodyShape{
        private int decksNumber;
        private int cargoHolds;

        BodyShape(String col, int decks, int cargo){
            super(col);
            decksNumber=decks;
            cargoHolds=cargo;
        }

        public String getDetailInformation(){
            return super.getDetailInformation()+", количество палуб: " + decksNumber +
                    ", количество грузовых трюмов: "+cargoHolds+
                    ", пассажиры: " + passengers +
                    ", скорость: " + getSpeed();
        }
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void setVehicleParameters(Scanner sc){
        super.setVehicleParameters(sc);
        int pas=-1;

        while (pas<0){
            System.out.println("Введите количество пассажиров:");
            pas=sc.nextInt();
        }
        this.passengers=pas;
    }

    @Override
    public void getVehicleParameters(){
        super.getVehicleParameters();
         System.out.print(", пассажиры: " + passengers);
    }

    @Override
    public void getVehicleCoordinates(){
        super.getVehicleCoordinates();
        System.out.print(", порт: " + port);
    }

    @Override
    public void setVehicleCoordinates(Scanner sc){
        super.setVehicleCoordinates(sc);
        System.out.println("Введите название порта:");
        this.port=sc.next();
    }

    @Override
    public String toString() {
        return super.toString()+
                ", порт: " + port  +
                ", пассажиры: " + passengers;
    }

    @Override
    public int swim() {
        return getSpeed();
    }
}
