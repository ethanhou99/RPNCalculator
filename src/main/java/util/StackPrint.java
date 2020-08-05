package util;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.LinkedList;


/**
 * @ClassName: StackPrint
 * @Description: Define a StackPrint class to print the result in numStack
 * @author Yicun Hou
 */
public class StackPrint {
    LinkedList<Double> numStack;
    private static final String REDUNDANT_ZEROS = "\\.*0*$";
    public StackPrint(LinkedList<Double> numStack) {
        this.numStack = numStack;
    }

    public void print() {
        System.out.print("stack: ");
        if (numStack.size() > 0) {
            for (int i = numStack.size() - 1; i >= 0; i--) {
                Double num = numStack.get(i);
                if (num % 1 == 0) {
                    System.out.print(num.intValue());
                } else {
                    double result = new BigDecimal(num).setScale(10, RoundingMode.FLOOR).doubleValue();
                    System.out.print(result);
                }
                if (i > 0) {
                    System.out.print(" ");
                }
            }
        }
        System.out.println();
    }
}
