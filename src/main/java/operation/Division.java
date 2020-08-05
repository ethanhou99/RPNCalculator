package operation;

import java.util.Deque;


/**
 * @ClassName: Division
 * @Description: Define a Division class to calculate the Division result
 * @author Yicun Hou
 */
public final class Division {
    public static Double run(Deque<Double> numStack) {
        double numb = numStack.pollFirst();
        double numa = numStack.pollFirst();
        double result = numa / numb;
        numStack.offerFirst(result);
        return result;
    }
}
