package util;

import operation.Operators;

import java.util.List;

public class ErrorHandler {
    public void print(Operators op, int index) {
        System.out.println ("operator " + op.getAction() + " (position: " + index + "): insufficient " +
                "parameters");
    }

    public void print(List<String> failedNum) {
        if (failedNum.size() > 0) {
            System.out.print("the ");
            for (int i = 0; i < failedNum.size(); i++) {
                System.out.print(failedNum.get(i));
                if (i < failedNum.size() - 2) {
                    System.out.print(", ");
                } else if (i == failedNum.size() - 2) {
                    System.out.print(", and ");
                }
            }
            System.out.println(" were not pushed on to the stack due to the previous error");
        }
    }
}
