import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.Math;
import static org.junit.Assert.assertEquals;
import rpn.RpnCalculator;


public class RPNCalculatorTest {
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    RpnCalculator rpc = new RpnCalculator();

    @Test
    public void testAllOperations() throws Exception {

        //example1: 5 2
        rpc.calculate("5 2");
        assertEquals(2, rpc.getNumStack().peek().intValue());
        assertEquals("stack: 5 2\n", outContent.toString());

        //example2: 2 sqrt
        rpc.calculate("clear");
        rpc.calculate("2 sqrt");
        assertEquals((Double)Math.sqrt(2), rpc.getNumStack().peek());
        assertEquals("stack: 5 2\n" + "stack: \n" +
                "stack: 1.4142135624\n", outContent.toString());


        //example3: 5 2 - | 3 - |clear
        rpc.calculate("clear");
        rpc.calculate("5 2 -");
        assertEquals(3, rpc.getNumStack().peek().intValue());
        rpc.calculate("3 -");
        assertEquals(0, rpc.getNumStack().peek().intValue());
        rpc.calculate("clear");
        assertEquals(0,  rpc.getNumStack().size());
        assertEquals("stack: 5 2\n" +
                "stack: \n" +
                "stack: 1.4142135624\n" +
                "stack: \n" +
                "stack: 3\n" +
                "stack: 0\n" +
                "stack: \n", outContent.toString());


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
        assertEquals("stack: 5 2\n" +
                "stack: \n" +
                "stack: 1.4142135624\n" +
                "stack: \n" +
                "stack: 3\n" +
                "stack: 0\n" +
                "stack: \n" +
                "stack: \n" +
                "stack: 5 4 3 2\n" +
                "stack: 20\n" +
                "stack: 100\n" +
                "stack: 20 5\n", outContent.toString());

        //example5: 7 12 2 / | * | 4 /
        rpc.calculate("clear");
        rpc.calculate("7 12 2 /");
        assertEquals(6, rpc.getNumStack().peek().intValue());
        rpc.calculate("*");
        assertEquals(42, rpc.getNumStack().peek().intValue());
        rpc.calculate("4 /");
        assertEquals(10.5, rpc.getNumStack().peek().doubleValue(), 0.0000000001);
        assertEquals("stack: 5 2\n" +
                "stack: \n" +
                "stack: 1.4142135624\n" +
                "stack: \n" +
                "stack: 3\n" +
                "stack: 0\n" +
                "stack: \n" +
                "stack: \n" +
                "stack: 5 4 3 2\n" +
                "stack: 20\n" +
                "stack: 100\n" +
                "stack: 20 5\n" +
                "stack: \n" +
                "stack: 7 6\n" +
                "stack: 42\n" +
                "stack: 10.5\n", outContent.toString());


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
        assertEquals("stack: 5 2\n" +
                "stack: \n" +
                "stack: 1.4142135624\n" +
                "stack: \n" +
                "stack: 3\n" +
                "stack: 0\n" +
                "stack: \n" +
                "stack: \n" +
                "stack: 5 4 3 2\n" +
                "stack: 20\n" +
                "stack: 100\n" +
                "stack: 20 5\n" +
                "stack: \n" +
                "stack: 7 6\n" +
                "stack: 42\n" +
                "stack: 10.5\n" +
                "stack: \n" +
                "stack: 1 2 3 4 5\n" +
                "stack: 1 2 3 20\n" +
                "stack: 1 2 3 20 -1\n" +
                "stack: \n" +
                "stack: 1 2 3 4 5\n" +
                "operator * (position: 9): insufficient parameters\n" +
                "stack: 120\n" +
                "stack: \n" +
                "operator * (position: 15): insufficient parameters\n" +
                "stack: 11\n" +
                "the 6 and 5 were not pushed on to the stack due to the previous error\n", outContent.toString());
    }

}
