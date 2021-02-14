package InnerClasses;

public class InnerClassAssisted1 {

    private String msg = "Welcome to Java.";

    class Inner
    {
        void hello () { System.out.println(msg + " Let us start learning inner classes.");}
    }

    public static void main (String[] args)
    {
        InnerClassAssisted1 obj = new InnerClassAssisted1();
        InnerClassAssisted1.Inner in = obj.new Inner();
        in.hello();
    }
    
}
