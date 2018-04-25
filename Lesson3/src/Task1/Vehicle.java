package Task1;

import java.util.Scanner;

public abstract class Vehicle {
    private int x;
    private int y;
    private int price;
    private int speed;
    private int year;
    private static String type="VEHICLE";

    public Vehicle( int x, int y, int price, int speed, int year) {
        this.x=x;
        this.y=y;
        this.price=price;
        this.speed=speed;
        this.year=year;
    }

    class BodyShape {
        private String color;

        public BodyShape (String color){
            this.color=color;
        }

        public String getDetailInformation(){
            return getType()+", цвет: " + color;
        }
    }

    public void getVehicleParameters(){
        System.out.print(getType()+" цена: " + price +
                ", год: " + year +
                ", скорость: " + speed);
    }

    public void setVehicleParameters(Scanner sc){
        int pr=-1;
        int sp=-1;
        int ye=-1;

        while (pr<0){
            System.out.println("Введите цену:");
            pr=sc.nextInt();
        }
        while (sp<0){
            System.out.println("Введите скорость:");
            sp=sc.nextInt();
        }
        while (ye<0){
            System.out.println("Введите год:");
            ye=sc.nextInt();
        }
        price=pr;
        speed=sp;
        year=ye;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getPrice() {
        return price;
    }

    public int getSpeed() {
        return speed;
    }

    public int getYear() {
        return year;
    }

    public String getType(){return type;}

    public void getVehicleCoordinates(){
        System.out.print(getType()+" координаты: " + x +" " + y);
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
               getType()+ " координаты: " + x +
                        " " + y +
                        ", цена: " + price +
                        ", год: " + year + ", скорость: " + speed;
    }
}
