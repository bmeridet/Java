package AccessMod;

class defAccessSpecifier
{
    void Display()
    {
        System.out.println("You are using the default access specifier.");
    }
}

public class DefAccess {
    
    public static void main(String[] args)
    {
        System.out.println("Default Access: ");
        defAccessSpecifier d = new defAccessSpecifier();
        d.Display();
    }

}
