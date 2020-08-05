package operation;

import java.util.LinkedList;

public class Clear {
    public static void run(LinkedList<Object> history, LinkedList<Double> numStack) {
        history.clear();
        numStack.clear();
    }
}
