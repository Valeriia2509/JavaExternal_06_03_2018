package Task1;

public class Car extends Vehicle {
    public Car(int price, int speed, int year, int x, int y){
        super(price,speed,year,x,y);
    }
    public String vehicleType(){
        return "Car";
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
