import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        System.out.println("Enter Calculation:");
        String exp = scn.next();

        Calculator calc = new Calculator(exp);

        double result = calc.Evaluate();

        System.out.println("Result: " + result);

        scn.close();
    }
}
