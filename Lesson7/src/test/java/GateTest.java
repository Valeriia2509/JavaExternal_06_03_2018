import org.junit.Test;
import static org.junit.Assert.*;

public class GateTest {

    @Test
    public void using() {
        Gate gate=new Gate(0,0);
        long t1 = System.currentTimeMillis();

        gate.using(200);

        long t2=System.currentTimeMillis();

        long actual=t2-t1;

        long expected=1000;

        assertTrue(Math.abs(expected-actual)<20);
    }
}