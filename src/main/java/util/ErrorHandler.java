package util;

import operation.Operators;

import java.util.List;



/**
 * @ClassName: ErrorHandler
 * @Description: Define a ErrorHandler class to handle all the error situations
 * @author Yicun Hou
 */
public class ErrorHandler {
    public void print(Operators op, int index) {
        System.out.println ("operator " + op.getAction() + " (position: " + index + "): insufficient " +
                "parameters");
    }

    public void print(String[] input, int index) {
        System.out.println("Your input '" + input[index] + "' in index" + index + " was invalid, please input again");
    }

    public void print(List<String> failedNum) {
        if (failedNum.size() > 1) {
            System.out.print("the ");
            for (int i = 0; i < failedNum.size(); i++) {
                System.out.print(failedNum.get(i));
                if (i < failedNum.size() - 2) {
                    System.out.print(", ");
                } else if (i == failedNum.size() - 2) {
                    if (failedNum.size() > 2) {
                        System.out.print(",");
                    }
                    System.out.print(" and ");
                }
            }
            System.out.println(" were not pushed on to the stack due to the previous error");
        } else if (failedNum.size() == 1) {
            System.out.println("the " + failedNum.get(0) + " was not pushed on to the stack due to the previous error");
        }
    }
}
