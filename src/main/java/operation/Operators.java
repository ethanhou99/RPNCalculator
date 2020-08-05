package operation;

public enum Operators {
    ADD ("+"),
    SUB ("-"),
    MUL ("*"),
    DIV ("/"),
    SQRT ("sqrt"),
    UNDO ("undo"),
    CLEAR ("clear");

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
