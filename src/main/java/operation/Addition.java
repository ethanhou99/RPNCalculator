package operation;

import com.sun.corba.se.spi.orb.Operation;

import java.util.Deque;

public final class Addition {
    public static Double run(Deque<Double> numStack) {
        double numb = numStack.pollFirst();
        double numa = numStack.pollFirst();
        double result = numa + numb;
        numStack.offerFirst(result);
        return result;
    }
}
