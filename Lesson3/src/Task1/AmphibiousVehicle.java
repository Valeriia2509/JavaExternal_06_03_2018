package Task1;

public class AmphibiousVehicle extends Car implements ISwim {
    private static String type="AMPHIBIOUSCAR";

    public AmphibiousVehicle( int x, int y, int price, int speed, int year) {
        super(x, y,price,speed,year);
    }

    public static class Engine{
        private static String engine="реактивный морской двигатель";

        public static String vehicleEngine(){
            return type+" "+engine;
        }
    }

    class BodyShape extends Car.BodyShape{
        public boolean isArmored;

        public BodyShape (String color, String bodyShape, boolean isArmored){
            super(color, bodyShape);
            this.isArmored=isArmored;
        }

        public String getDetailInformation(){
            return super.getDetailInformation()+", бронированный: "+isArmored;
        }
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void getVehicleParameters(){
        super.getVehicleParameters();
        System.out.print(" (по суше), "+swim()+" (в воде)");
    }
    @Override
    public int swim() {
        return getSpeed()/3;
    }

    @Override
    public String toString(){
        return super.toString()+" (по суше), "+swim()+" (в воде)";
    }
}
