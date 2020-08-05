package util;

import operation.Operators;


/**
 * @ClassName: InputChecker
 * @Description: Define a InputerChecker class to check if the input is valid
 * @author Yicun Hou
 */
public class InputChecker {
    private final static String NUMREGEX = "\\d+";
    private final static String FLOATREGEX = "[+-]?\\d+(\\.\\d+)";
    public static int check(String[] input) {
        for (int i = 0; i < input.length; i++) {
            String cur = input[i];
            if (cur.matches(NUMREGEX) || cur.matches(FLOATREGEX) || Operators.set.contains(cur)) {
                continue;
            }
            return i;
        }
        return -1;
    }
}
