package rpn;

import java.util.Scanner;

public class RpnMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        RpnCalculator rpn = new RpnCalculator();
        System.out.println("Please input operations, input 'exit' to exit program：");
        while (true) {
            String input = sc.nextLine();
            if (input.equals("exit")) {
                break;
            }
            rpn.calculate(input);
        }
    }
}
