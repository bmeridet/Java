package InnerClasses;

public class InnerClassAssisted2 {

    private String msg = "Inner classes.";

    void Display ()
    {
        class  Inner
        {
            void msg() { System.out.println(msg);}
        }

        Inner I = new Inner();
        I.msg();
    }

    public static void main (String[] args)
    {
        InnerClassAssisted2 obj = new InnerClassAssisted2();
        obj.Display();
    }
    
}
