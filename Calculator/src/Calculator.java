package Calculator.src;

import java.util.*;

public class Calculator {

    private String[] exp;
    private int length;
    private String[] postFix;
    private double currentTotal;

    public Calculator(String[] _exp, int _length)
    {
        exp = _exp;
        length = _length;
        postFix = new String[length];
        currentTotal = 0;
    }

    private void PostFix()
    {
        Stack<String> s = new Stack<String>();

        int i = 0;
        int j = 0;
        while (i < length)
        {
            if (IsOperand(exp[i]))
                postFix[j++] = exp[i++];
            else
            {
                if (s.empty())
                    s.push(exp[i++]);
                else if (PreOut(exp[i]) == 0 && PreIn(s.peek()) > PreOut(exp[i]))
                    postFix[j++] = s.pop();
                else if (PreOut(exp[i]) == PreIn(s.peek()))
                {
                    s.pop();
                    length = length - 2;
                    i++;
                }
                else if (PreOut(exp[i]) > PreIn(s.peek()))
                    s.push(exp[i++]);
                else
                    postFix[j++] = s.pop();
            }
        }

        while (!s.empty())
            postFix[j++] = s.pop();
    }

    private boolean IsOperand(String s)
    {
        char x = s.charAt(0);
        if (x == '+' || x == '-' || x == '*' || x == '/' || x == '^' || x == '(' || x == ')')
        {
            return false;
        }
        else 
            return true;
    }

    private int PreOut(String s)
    {
        char x = s.charAt(0);
        if (x == '+' || x == '-')
            return 1;
        else if (x == '*' || x == '/')
            return 3;
        else if (x == '^')
            return 6;
        else if (x == '(')
            return 7;
        else if (x == ')')
            return 0;
        else
            return -1;
    }

    private int PreIn(String s)
    {
        char x = s.charAt(0);
        if (x == '+' || x == '-')
            return 2;
        else if (x == '*' || x == '/')
            return 4;
        else if (x == '^')
            return 5;
        else if (x == '(')
            return 0;
        else 
            return -1;
    }
    
    public double Evaluate()
    {
        PostFix();
        Stack<Integer> s = new Stack<Integer>();

        int x;
        int y;

        int i = 0;
        while (i < length)
        {
            if (IsOperand(postFix[i]))
                s.push(Integer.parseInt(postFix[i++]));
            else
            {
                y = s.pop();
                x = s.pop();

                switch (postFix[i])
                {
                    case "+":
                        s.push(x + y);
                        break;
                    case "-":
                        s.push(x - y);
                        break;
                    case "*":
                        s.push(x * y);
                        break;
                    case "/":
                        s.push(x / y);
                        break;
                    case "^":
                        int result = 1;
                        for (int j = 0; j < y; ++j)
                        {
                            result *= x;
                        }
                        s.push(result);
                        break;
                    default:
                        break;
                }
                i++;
            }
        }

        currentTotal += s.pop();
        return currentTotal;
    }

    public void SetExpression(String[] _exp)
    {
        exp = _exp;
    }

    public void Reset()
    {
        currentTotal = 0;
    }

    public void PrintPostFix()
    {
        PostFix();
        for (int i = 0; i < length; ++i)
            System.out.println(postFix[i] + " ");
        System.out.println();
    }

}
