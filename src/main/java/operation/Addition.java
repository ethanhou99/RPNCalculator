package operation;

import java.util.Deque;


/**
 * @ClassName: Addition
 * @Description: Define a Addidtion class to calculate the addition result
 * @author Yicun Hou
 */
public final class Addition {
    public static Double run(Deque<Double> numStack) {
        double numb = numStack.pollFirst();
        double numa = numStack.pollFirst();
        double result = numa + numb;
        numStack.offerFirst(result);
        return result;
    }
}
