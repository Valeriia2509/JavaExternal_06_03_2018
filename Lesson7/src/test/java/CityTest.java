import org.junit.Test;

import static org.junit.Assert.*;

public class CityTest {

    @Test
    public void getDistanceZone() throws ParametersException {
        City city=new City("Лондон",2000,1);
        int expected=2;
        assertEquals(expected,city.getDistanceZone());

        City city1=new City("Варшава",780,4);
        int expected1=1;
        assertEquals(expected1,city1.getDistanceZone());

        City city2=new City("Египет",4200,4);
        int expected2=3;
        assertEquals(expected2,city2.getDistanceZone());
        try{
            City city3=new City("Египет",-4200,4);
        }
        catch (ParametersException e){
            System.out.println("Exception catched");
        }
    }
}
