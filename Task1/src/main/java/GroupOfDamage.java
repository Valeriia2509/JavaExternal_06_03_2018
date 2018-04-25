import java.util.ArrayList;

public class GroupOfDamage {
    private String typeOfDamage;
    private ArrayList<InsuranceEvent> insuranceEvents=new ArrayList<>();

    public GroupOfDamage(String typeOfDamage) {
        this.typeOfDamage=typeOfDamage;
    }

    public void addInsuranceEvent(InsuranceEvent inEv){
        insuranceEvents.add(inEv);
    }

    public String getTypeOfDamage() {
        return typeOfDamage;
    }

    public ArrayList<InsuranceEvent> getInsuranceEvents() {
        return insuranceEvents;
    }

    public void printDamages() {
        System.out.println(typeOfDamage);
        System.out.println("\tСтраховой случай\tВзнос\tВыплата");
        for (int i=0; i<insuranceEvents.size(); i++){
            System.out.println((i+1)+". \t"+insuranceEvents.get(i));
        }
    }
}
