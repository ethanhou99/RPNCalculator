package operation;

import java.util.Deque;

public final class Division {
    public static Double run(Deque<Double> numStack) {
        double numb = numStack.pollFirst();
        double numa = numStack.pollFirst();
        double result = numa / numb;
        numStack.offerFirst(result);
        return result;
    }
}
