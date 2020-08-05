package operation;

import java.util.Deque;

public final class SquareRoot {
    public static Double run(Deque<Double> numStack) {
        double num = numStack.pollFirst();
        double result = Math.sqrt(num);
        numStack.offerFirst(result);
        return result;
    }
}
