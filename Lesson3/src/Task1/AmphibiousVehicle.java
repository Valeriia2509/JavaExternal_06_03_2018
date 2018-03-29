package Task1;

public class AmphibiousVehicle extends Car implements IMove, ISwim {

    public AmphibiousVehicle(int price, int speed, int year, int x, int y) {
        super(price, speed, year, x, y);
    }

    public String vehicleType(){
        return "AmphibiousVehicle";
    }

    @Override
    public int swim() {
        return getSpeed()/10;
    }
}
