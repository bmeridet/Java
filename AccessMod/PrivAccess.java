package AccessMod;

class PrivAccessSpec
{
    private void Display()
    {
        System.out.println("You are using the private access speciifer");
    }

    void CallPriv()
    {
        Display();
    }
}

public class PrivAccess {

    public static void main(String[] args)
    {
        // Can't access Dispaly method.
        PrivAccessSpec obj = new PrivAccessSpec();
        //obj.Display(); ERROR
        obj.CallPriv();
    }
    
}
