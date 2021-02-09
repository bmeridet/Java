package Method;

public class Method {

    public int Multiply(int a, int b)
    {
        return a * b;
    }

    public void Area(int a, int b)
    {
        System.out.println("Area of Triangle: " + (0.5 * a * b));
    }

    public void Area(int r)
    {
        System.out.println("Area of Circle: " + (3.14 * (r * r)));
    }

   public static void main(String[] args)
   {
        Method m = new Method();
        System.out.println("Multiplication result is: " + m.Multiply(5, 5));

        m.Area(5, 5); // Triangle
        m.Area(5);    // Circle
   } 
}
