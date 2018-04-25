package Task1;

import java.util.Scanner;

public class Plane extends Vehicle implements IFly{
    private int hight;
    private int passengers;
    private static String type="PLANE";

    public Plane(int x, int y, int price, int speed, int year, int hig, int pas){
        super(x,y,price,speed,year);
        this.hight=hig;
        this.passengers=pas;
    }

    public static class Engine{
        private static String engine="реактивный двигатель";

        public static String vehicleEngine(){
            return type+" "+engine;
        }
    }

    class BodyShape extends Vehicle.BodyShape{
        private boolean isBusinessClass;

        BodyShape(String color, boolean isBusClass){
            super(color);
            isBusinessClass=isBusClass;
        }

        public String getDetailInformation(){
            return super.getDetailInformation()+", наличие бизнесс класса: " + isBusinessClass +
                    ", пассажиры: " + passengers +
                    ", скорость: " + getSpeed();
        }
    }

    @Override
    public void getVehicleParameters(){
        super.getVehicleParameters();
        System.out.print(", высота: " + hight  +
                ", пассажиры: " + passengers);
    }

    @Override
    public void setVehicleParameters(Scanner sc){
        super.setVehicleParameters(sc);
        int hi=-1;
        int pas=-1;

        while (pas<0){
            System.out.println("Введите количество пассажиров:");
            pas=sc.nextInt();
        }
        this.passengers=pas;

        while (hi<0){
            System.out.println("Введите высоту:");
            hi=sc.nextInt();
        }
        this.hight=hi;
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return super.toString()+
                ", высота: " + hight  +
                ", пассажиры: " + passengers;
    }

    @Override
    public int fly() {
        return getSpeed();
    }
}
