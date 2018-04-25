import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlaneTest {
    private Airport airport=new Airport();

    @Test
    public void run() throws ParametersException, InterruptedException, ResourсeException {
        City city1= new City("Варшава",780,4);
        Plane plane1=new Plane(airport, 2500, 600);
        plane1.setRoute(city1);

        airport.getGate(10000);
        airport.getGate(10000);
        plane1.run();
    }

    @Test
    public void setRoute() throws ParametersException {
        System.out.println();
        City city1= new City("Варшава",780,4);
        Plane plane1=new Plane(airport, 2500, 200);
        plane1.setRoute(city1);

        assertNotNull(plane1.getRoute());

        City city2= new City("Магадан",5000,4);
        Plane plane2=new Plane(airport, 2500, 200);
        plane2.setRoute(city2);

        assertNull(plane2.getRoute());

        City city3= new City("Варшава",780,4);
        Plane plane3=new Plane(airport, 500, 200);
        plane1.setRoute(city3);

        assertNull(plane3.getRoute());
    }

    @Test
    public void getDistantZone() throws ParametersException {
        System.out.println();
        Plane plane=new Plane(airport, 1500, 200);
        int expected=1;
        assertEquals(expected,plane.getDistantZone());

        Plane plane1=new Plane(airport, 2500, 200);
        int expected1=2;
        assertEquals(expected1,plane1.getDistantZone());

        Plane plane2=new Plane(airport, 4500, 200);
        int expected2=3;
        assertEquals(expected2,plane2.getDistantZone());

        try {
            Plane plane3 = new Plane(airport, -2500, 200);
        }
        catch (ParametersException e){
            System.out.println("Exception catched");
        }
        try {
            Plane plane4 = new Plane(airport, 2500, -200);
        }
        catch (ParametersException e){
            System.out.println("Exception catched");
        }
    }
}