package operation;

import java.util.Deque;



/**
 * @ClassName: Subtraction
 * @Description: Define a Subtraction class to calculate the subtraction result
 * @author Yicun Hou
 */
public final class Subtraction{
    public static Double run(Deque<Double> numStack) {
        double numb = numStack.pollFirst();
        double numa = numStack.pollFirst();
        double result = numa - numb;
        numStack.offerFirst(result);
        return result;
    }
}
