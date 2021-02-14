package InnerClasses;

public class InnerClassAssisted3 {

    public static void main (String[] args)
    {
        AnonymousClass A = new AnonymousClass(){
            public void Display () { System.out.println("Anonynous inner class."); }
        };

        A.Display();
    }
    
}
