package operation;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public enum Operators {
    ADD ("+"),
    SUB ("-"),
    MUL ("*"),
    DIV ("/"),
    SQRT ("sqrt"),
    UNDO ("undo"),
    CLEAR ("clear");

    final public static Set<String> set = new HashSet<>(Arrays.asList("+", "-", "*", "/", "sqrt", "undo", "clear"));

    private String action;

    public String getAction() {
        return this.action;
    }

    Operators(String action) {
        this.action = action;
    }

    public static Operators get(String pattern) {
        for (Operators op : values()) {
            if (op.getAction().equals(pattern)) {
                return op;
            }
        }
        return null;
    }
}
