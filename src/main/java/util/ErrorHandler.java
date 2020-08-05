package util;

import operation.Operators;

import java.util.List;

public class ErrorHandler {
    public void print(Operators op, int index) {
        System.out.println ("operator " + op.getAction() + " (position: " + index + "): insufficient " +
                "parameters");
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
