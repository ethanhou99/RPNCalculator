
import org.junit.Test;
import java.lang.Math;
import static org.junit.Assert.assertEquals;
import rpn.RpnCalculator;


public class RPNCalculatorTest {

    RpnCalculator rpc = new RpnCalculator();

    @Test
    public void testSample() throws Exception {
        //example1: 5 2
        rpc.calculate("5 2");
        assertEquals(2, rpc.getNumStack().peek().intValue());

        //example2: 2 sqrt
        rpc.calculate("clear");
        rpc.calculate("2 sqrt");
        assertEquals((Double)Math.sqrt(2), rpc.getNumStack().peek());


        //example3: 5 2 - | 3 - |clear
        rpc.calculate("clear");
        rpc.calculate("5 2 -");
        assertEquals(3, rpc.getNumStack().peek().intValue());
        rpc.calculate("3 -");
        assertEquals(0, rpc.getNumStack().peek().intValue());
        rpc.calculate("clear");
        assertEquals(0,  rpc.getNumStack().size());


        //example4: 5 4 3 2 | undo undo * | 5 * | undo
        rpc.calculate("clear");
        rpc.calculate("5 4 3 2");
        assertEquals(2, rpc.getNumStack().peek().intValue());
        rpc.calculate("undo undo *");
        assertEquals(20, rpc.getNumStack().peek().intValue());
        rpc.calculate("5 *");
        assertEquals(100, rpc.getNumStack().peek().intValue());
        rpc.calculate("undo");
        assertEquals(5, rpc.getNumStack().peek().intValue());

        //example5: 7 12 2 / | * | 4 /
        rpc.calculate("clear");
        rpc.calculate("7 12 2 /");
        assertEquals(6, rpc.getNumStack().peek().intValue());
        rpc.calculate("*");
        assertEquals(42, rpc.getNumStack().peek().intValue());
        rpc.calculate("4 /");
        assertEquals(10.5, rpc.getNumStack().peek().doubleValue(), 0.0000000001);

        //exampple6: 1 2 3 4 5 | * | 3 4 -
        rpc.calculate("clear");
        rpc.calculate("1 2 3 4 5");
        assertEquals(5, rpc.getNumStack().peek().intValue());
        rpc.calculate("*");
        assertEquals(20, rpc.getNumStack().peek().intValue());
        rpc.calculate("3 4 -");
        assertEquals(-1, rpc.getNumStack().peek().intValue());

        //example7: 1 2 3 4 5 | * * * * *
        rpc.calculate("clear");
        rpc.calculate("1 2 3 4 5");
        assertEquals(5, rpc.getNumStack().size());
        rpc.calculate("* * * * *");
        assertEquals(120, rpc.getNumStack().peek().intValue());
        assertEquals(1, rpc.getNumStack().size());

        //example8: 1 2 3 * 5 + * * 6 5
        rpc.calculate("clear");
        rpc.calculate("1 2 3 * 5 + * * 6 5");
        assertEquals(11, rpc.getNumStack().peek().intValue());
        assertEquals(1, rpc.getNumStack().size());
    }

}
