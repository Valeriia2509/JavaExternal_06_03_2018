package Task1;

public class BatMobile extends Car implements IFly,ISwim {

    public BatMobile(int price, int speed, int year, int x, int y) {
        super(price, speed, year, x, y);
    }

    @Override
    public String vehicleType(){
        return "BatMobile";
    }

    @Override
    public int fly() {
        return getSpeed()*10;
    }

    @Override
    public int swim() {
        return getSpeed()/10;
    }
}
