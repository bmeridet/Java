import java.util.*;

public class Calculator {

    String exp;
    String postFix;
    private double currentTotal;

    public Calculator(String _exp)
    {
        exp = _exp;
        postFix = "";
        currentTotal = 0;
    }

    private void PostFix()
    {
        Stack<Character> s = new Stack<Character>();

        int i = 0;
        int n = exp.length();
        while (i < n)
        {
            if (IsOperand(exp.charAt(i)))
                postFix += exp.charAt(i++);
            else
            {
                if (s.empty())
                    s.push(exp.charAt(i++));
                else if (PreOut(exp.charAt(i)) == 0 && PreIn(s.peek()) > PreOut(exp.charAt(i)))
                    postFix += s.pop();
                else if (PreOut(exp.charAt(i)) == PreIn(s.peek()))
                {
                    s.pop();
                    i++;
                }
                else if (PreOut(exp.charAt(i)) > PreIn(s.peek()))
                    s.push(exp.charAt(i++));
                else
                    postFix += s.pop();
            }
        }

        while (!s.empty())
            postFix += s.pop();
    }

    private boolean IsOperand(char x)
    {
        if (x == '+' || x == '-' || x == '*' || x == '/' || x == '^' || x == '(' || x == ')')
            return false;
        else 
            return true;
    }

    private int PreOut(char x)
    {
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

    private int PreIn(char x)
    {
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
        int n = postFix.length();
        while (i < n)
        {
            if (IsOperand(postFix.charAt(i)))
                s.push(postFix.charAt(i++) - '0');
            else
            {
                x = s.pop();
                y = s.pop();

                switch (postFix.charAt(i))
                {
                    case '+':
                        s.push(x + y);
                        break;
                    case '-':
                        s.push(x - y);
                        break;
                    case '*':
                        s.push(x * y);
                        break;
                    case '/':
                        s.push(x / y);
                        break;
                    case '^':
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

    public void SetExpression(String _exp)
    {
        exp = _exp;
    }

    public void Reset()
    {
        currentTotal = 0;
    }

}
