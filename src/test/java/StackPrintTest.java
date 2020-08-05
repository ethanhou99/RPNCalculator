import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import rpn.RpnCalculator;
import util.StackPrint;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;

import static org.junit.Assert.assertEquals;

public class StackPrintTest {
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

    @Test
    public void testStackwithComtent() throws Exception {
        LinkedList<Double> stack = new LinkedList<>();
        stack.add(1.0);
        stack.add(2.59374507458723);
        stack.add(6.59374507345458723);
        StackPrint sp = new StackPrint(stack);
        sp.print();
        assertEquals("stack: 6.5937450734 2.5937450745 1\n", outContent.toString());
    }

    @Test
    public void testStackwithoutComtent() throws Exception {
        LinkedList<Double> stack = new LinkedList<>();
        StackPrint sp = new StackPrint(stack);
        sp.print();
        assertEquals("stack: \n", outContent.toString());
    }
}
