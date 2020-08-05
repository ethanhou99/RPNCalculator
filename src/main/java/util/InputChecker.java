package util;

import operation.Operators;

public class InputChecker {
    private final static String NUMREGEX = "\\d+";
    public static int check(String[] input) {
        for (int i = 0; i < input.length; i++) {
            String cur = input[i];
            if (cur.matches(NUMREGEX) || Operators.set.contains(cur)) {
                continue;
            }
            return i;
        }
        return -1;
    }
}
