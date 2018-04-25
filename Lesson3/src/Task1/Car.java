package Task1;

import java.util.Scanner;

public class Car extends Vehicle implements IMove{
    private static String type="CAR";

    public Car(int x, int y, int price, int speed, int year){
        super(x,y,price,speed,year);
    }

    public static class Engine{
        private static String engine="электромотор";

        public static String vehicleEngine(){
            return type+" "+engine;
        }
    }

    class BodyShape extends Vehicle.BodyShape{
        private String bodyShape;

        public BodyShape (String color, String bodyShape){
            super(color);
            this.bodyShape=bodyShape;
        }

        public String getDetailInformation(){
            return super.getDetailInformation()+", тип кузова: " + bodyShape +
                    ", скорость: " + getSpeed();
        }
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public int move() {
        return getSpeed();
    }
}
