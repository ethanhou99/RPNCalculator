package operation;

import java.util.Deque;


/**
 * @ClassName: SquareRoot
 * @Description: Define a SquareRoot class to calculate the SquareRoot result
 * @author Yicun Hou
 */
public final class SquareRoot {
    public static Double run(Deque<Double> numStack) {
        double num = numStack.pollFirst();
        double result = Math.sqrt(num);
        numStack.offerFirst(result);
        return result;
    }
}
