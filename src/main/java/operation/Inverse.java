package operation;


/**
 * @ClassName: Inverse
 * @Description: Define a Inverse class to support the undo operation
 * @author Yicun Hou
 */
public class Inverse {
    public static Double run(Double a, Double b, Operators op) {
        switch(op) {
            case ADD:
                return a - b;
            case SUB:
                return a + b;
            case MUL:
                return a / b;
            case DIV:
                return a * b;
            default:
                return null;
        }
    }
}
