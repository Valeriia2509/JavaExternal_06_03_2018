import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.*;

public class LifeInsuranceTest {
    private LifeInsurance lifeInsurance;

    @Before
    public void createLifeInsurance(){
        lifeInsurance=new LifeInsurance();
    }

    @org.junit.Test
    public void getSumYearInsurancePayment(){
        ArrayList<InsuranceEvent> events=new ArrayList<>();
        events.add(new InsuranceEvent("someth1",10,100));
        events.add(new InsuranceEvent("someth2",20,200));
        events.add(new InsuranceEvent("someth3",30,300));
        int expected=60;

        assertEquals(expected,lifeInsurance.getSumYearInsurancePayment(events));
    }

    @Test
    public void sortInsuranceEventsByYearPayment() {
        ArrayList<InsuranceEvent> events=new ArrayList<>();
        InsuranceEvent event1=new InsuranceEvent("someth1",10,100);
        InsuranceEvent event2=new InsuranceEvent("someth2",20,200);
        InsuranceEvent event3=new InsuranceEvent("someth3",30,300);
        events.add(event1);
        events.add(event2);
        events.add(event3);

        ArrayList<InsuranceEvent> expected=new ArrayList<>();
        expected.add(event3);
        expected.add(event2);
        expected.add(event1);

        ArrayList<InsuranceEvent> actual=lifeInsurance.sortInsuranceEventsByYearPayment(events);

        assertTrue(Arrays.equals(expected.toArray(),actual.toArray()));
    }
}