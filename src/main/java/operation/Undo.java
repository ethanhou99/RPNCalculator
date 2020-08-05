package operation;

import java.util.LinkedList;

public class Undo {
    public static void run(LinkedList<Object> history, LinkedList<Double> numStack) {
        if (history.size() > 0) {
            Object item = history.pollFirst();
            if (item.getClass().isAssignableFrom(Operators.class)) {
                Double result = numStack.pollFirst();
                Double a = Double.parseDouble(history.peekFirst().toString());
                Object b = history.get(1);
                if (b.getClass().isAssignableFrom(Operators.class)) {
                    b = Inverse.run(result, a, (Operators) b);
                }
                numStack.offerFirst(Double.valueOf(b.toString()));
                numStack.offerFirst(a);
            } else {
                numStack.pollFirst();
            }
        }
    }
}
