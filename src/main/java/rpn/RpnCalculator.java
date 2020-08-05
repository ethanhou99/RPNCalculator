package rpn;

import operation.*;
import util.ErrorHandler;
import util.StackPrint;

import java.util.*;

public class RpnCalculator {
    private final LinkedList<Double> numStack;
    private final LinkedList<Object> history;

    public RpnCalculator() {
        numStack  = new LinkedList<>();
        history = new LinkedList<>();
    }

    public void calculate(String input) {
        String[] inputArray = input.split(" ");
        List<String> failedNum = new ArrayList<>();
        boolean error = false;
        for (int i = 0; i < inputArray.length; i++) {
            String item = inputArray[i];
            if (item != null && !item.equals("")) {
                if (error) failedNum.add(item);
                Operators op = Operators.get(item);
                if (op == null && !error) {
                    history.offerFirst(item);
                    numStack.offerFirst(Double.parseDouble(item));
                } else if (!error) {
                    if (op != Operators.UNDO && op != Operators.CLEAR) {
                        history.offerFirst(op);
                        error = (op == Operators.SQRT && numStack.size() == 0 ||
                                 op != Operators.SQRT && numStack.size() < 2);
                    }
                    if (error) {
                        ErrorHandler handler = new ErrorHandler();
                        handler.print(op, 2 * i + 1);
                    } else {
                        switch (op) {
                            case ADD:
                                Addition.run(numStack);
                                break;
                            case SUB:
                                Subtraction.run(numStack);
                                break;
                            case MUL:
                                Multiplication.run(numStack);
                                break;
                            case DIV:
                                Division.run(numStack);
                                break;
                            case SQRT:
                                SquareRoot.run(numStack);
                                break;
                            case UNDO:
                                Undo.run(history, numStack);
                                break;
                            case CLEAR:
                                Clear.run(history, numStack);
                                break;
                            default:
                                break;

                        }
                    }
                }
            }
        }
        StackPrint printer = new StackPrint(numStack);
        printer.print();
        if (error) {
            ErrorHandler handler = new ErrorHandler();
            handler.print(failedNum);
        }
    }
}
