package Task1;

public class BatMobile extends AmphibiousVehicle implements IFly {
    private static String type="BATMOBILE";

    public BatMobile(int x, int y, int price, int speed, int year) {
        super(x, y, price, speed, year);
    }

    public static class Engine{
        private static String engine="реактивный двигатель";

        public static String vehicleEngine(){
            return type+" "+engine;
        }
    }

    class BodyShape extends AmphibiousVehicle.BodyShape{
        private boolean hasWeapon;

        public BodyShape (String col,String bodyShape, boolean isArmored, boolean hasWeap){
            super(col,bodyShape,isArmored);
            hasWeapon=hasWeap;
        }

        public String getDetailInformation(){
            return super.getDetailInformation()+", наличие оружия: "+hasWeapon;
        }
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public void getVehicleParameters(){
        super.getVehicleParameters();
        System.out.print(" "+fly()+" (в полете)");
    }
    @Override
    public int fly() {
        return getSpeed()*3;
    }

    @Override
    public String toString(){
        return super.toString()+" "+fly()+" (в полете)";
    }

}
