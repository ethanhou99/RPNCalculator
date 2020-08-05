import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.lang.Math;
import static org.junit.Assert.assertEquals;
import rpn.RpnCalculator;


public class ErrorHandlerTest {
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
    public void zeroDivisor() throws Exception {
        //example: 1 0 / 2 3 4
        rpc.calculate("1 0 / 2 3 4");
        assertEquals("Your input '/' in index2 caused 0 divisor, please try another operation\n" +
        "operator / (position: 2): insufficient parameters\n" + "stack: 1 0\n" +
        "the 2, 3, and 4 were not pushed on to the stack due to the previous error\n", outContent.toString());
    }

    @Test
    public void insufficientParameters() throws Exception {
        //example: 1 0 5 / + * 2 3 4
        rpc.calculate("1 0 5 / + * 2 3 4");
        assertEquals("operator * (position: 11): insufficient parameters\n" + "stack: 1\n" +
                "the 2, 3, and 4 were not pushed on to the stack due to the previous error\n", outContent.toString());
    }

    @Test
    public void invalidInput() throws Exception {
        //example: 1 0 5 /9
        rpc.calculate("1 0 5 /9");
        assertEquals("Your input '/9' in index3 was invalid, please input again\n", outContent.toString());
    }

    @Test
    public void invalidOperation() throws Exception {
        //example: 1 0 5 / + -
        rpc.calculate("1 0 5 / + -");
        assertEquals("operator - (position: 11): insufficient parameters\n" + "stack: 1\n", outContent.toString());
    }
}
