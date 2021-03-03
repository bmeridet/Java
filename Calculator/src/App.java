package Calculator.src;

import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner scn1 = new Scanner(System.in);
        System.out.println("Enter Calculation:");
        String input = scn1.nextLine();

        Scanner scn2 = new Scanner(input);
        String[] exp = new String[50];
        int i = 0;

        String s;
        while (scn2.hasNext())
        {
            s = scn2.next();
            exp[i++] = s;
        }
        
        Calculator calc = new Calculator(exp, i);

        double result = calc.Evaluate();

        System.out.println("Result: " + result);

        scn1.close();
        scn2.close();
    }
}
