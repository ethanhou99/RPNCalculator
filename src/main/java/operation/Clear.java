package operation;

import java.util.LinkedList;


/**
 * @ClassName: Clear
 * @Description: Define a Clear class to clear all the results in the Stack
 * @author Yicun Hou
 */
public class Clear {
    public static void run(LinkedList<Object> history, LinkedList<Double> numStack) {
        history.clear();
        numStack.clear();
    }
}
