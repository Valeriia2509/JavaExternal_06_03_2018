public class InsuranceEvent {
    private String damage;
    private int insuranceDamagePayment;
    private int yearInsurancePayment;

    public InsuranceEvent(String d, int yIP, int iDP){
        damage=d;
        insuranceDamagePayment=iDP;
        yearInsurancePayment=yIP;
    }

    public int getYearInsurancePayment() {
        return yearInsurancePayment;
    }

    @Override
    public String toString() {
        return damage +"\t"+  yearInsurancePayment +
                "\t\t" + insuranceDamagePayment ;
    }
}
