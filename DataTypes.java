import java.util.Scanner;

public class DataTypes {

    public static boolean IsInteger(String s)
    {
        try
        {
            Integer.parseInt(s);
            return true;
        }
        catch(NumberFormatException ex)
        {
            return false;
        }
    }

    public static boolean IsFloat(String s)
    {
        try
        {
            Float.parseFloat(s);
            return true;
        }
        catch(NumberFormatException ex)
        {
            return false;
        }
    }

    public static boolean IsDouble(String s)
    {
        try
        {
            Double.parseDouble(s);
            return true;
        }
        catch(NumberFormatException ex)
        {
            return false;
        }
    }

    public static boolean IsLong(String s)
    {
        try
        {
            Long.parseLong(s);
            return true;
        }
        catch(NumberFormatException ex)
        {
            return false;
        }
    }

    public static boolean IsByte(String s)
    {
        try
        {
            Byte.parseByte(s);
            return true;
        }
        catch(NumberFormatException ex)
        {
            return false;
        }
    }

    public static boolean IsShort(String s)
    {
        try
        {
            Short.parseShort(s);
            return true;
        }
        catch(NumberFormatException ex)
        {
            return false;
        }
    }

    public static boolean IsChar(String s)
    {
        if (s.length() == 1)
        {
            char c = s.charAt(0);
            try
            {
                Character.isLetter(c);
                return true;
            }
            catch(RuntimeException ex)
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    public static boolean IsBool(String s)
    {
        try
        {
            Boolean.parseBoolean(s);
            return true;
        }
        catch(NumberFormatException ex)
        {
            return false;
        }
    }

    public static void PrintMenu()
    {
        System.out.println("Select Conversion:\n1. Integer\n2. Float\n3. Double\n4. Long\n5. Short\n6. Byte\n7. Char\n8. Boolean\n0. Exit\n");
    }

    public static String GetDataInput(Scanner scn)
    {
        System.out.println("Enter the data to convert: ");
        String s = scn.next();
        return s;
    }
    public static void main (String[] args) {
        Scanner scn = new Scanner(System.in);

        PrintMenu();
        int input = scn.nextInt();

        String s;
        while (input != 0)
        {
            s = GetDataInput(scn);

            switch(input)
            {
                case 1: // int
                    if (IsInteger(s))
                    {
                        int x = Integer.parseInt(s);
                        System.out.println("Data converted: " + x);
                    }
                    else 
                    {
                        System.out.println("Input cannot be converted to integer.");
                    }
                    break;

                case 2: // float
                    if (IsFloat(s))
                    {
                        float x = Float.parseFloat(s);
                        System.out.println("Data converted: " + x);
                    }
                    else 
                    {
                        System.out.println("Input cannot be converted to float.");
                    }
                    break;

                case 3: // double
                    if (IsDouble(s))
                    {
                        double x = Double.parseDouble(s);
                        System.out.println("Data converted: " + x);
                    }
                    else 
                    {
                        System.out.println("Input cannot be converted tp double.");
                    }
                    break;

                case 4: // long
                    if (IsLong(s))
                    {
                        long x = Long.parseLong(s);
                        System.out.println("Data converted: " + x);
                    }
                    else 
                    {
                        System.out.println("Input cannot be converted to long.");
                    }
                    break;

                case 5: // short
                    if (IsShort(s))
                    {
                        short x = Short.parseShort(s);
                        System.out.println("Data converted: " + x);
                    }
                    else 
                    {
                        System.out.println("Input cannot be converted to short.");
                    }
                    break;

                case 6: // byte
                    if (IsByte(s))
                    {
                        byte x = Byte.parseByte(s);
                        System.out.println("Data converted: " + x);
                    }
                    else 
                    {
                        System.out.println("Input cannot be converted to byte.");
                    }
                    break;

                case 7: // char
                    if (IsChar(s))
                    {
                        char x = s.charAt(0);
                        System.out.println("Data converted: " + x);
                    }
                    else 
                    {
                        System.out.println("Input cannot be converted to char.");
                    }
                    break;

                case 8: // boolean
                    if (IsBool(s))
                    {
                        boolean x = Boolean.parseBoolean(s);
                        System.out.println("Data converted: " + x);
                    }
                    else 
                    {
                        System.out.println("Input cannot be converted to boolean.");
                    }
                    break;

                default: // invalid
                    System.out.println("Invalid input.  Try again.");
                    break;
            }

            PrintMenu();
            input = scn.nextInt();
        }

        scn.close();
    }

}