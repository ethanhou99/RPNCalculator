import org.junit.Test;
import util.InputChecker;

import static org.junit.Assert.assertEquals;

public class InputCheckerTest {

    @Test
    public void testInvalidInput() throws Exception {
        String[] input = new String[]{"1", "2", "&"};
        InputChecker checker = new InputChecker();
        int result = checker.check(input);
        assertEquals(2, result);
    }

    @Test
    public void testValidInput() throws Exception {
        String[] input = new String[]{"1", "2", "+"};
        InputChecker checker = new InputChecker();
        int result = checker.check(input);
        assertEquals(-1, result);
    }
}
