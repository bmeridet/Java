package Phase1_Project;

import java.util.Scanner;

public class FileMain {

    public static final Scanner scn = new Scanner(System.in);

    public static void main (String[] args)
    {
        System.out.println("Enter directory for data storage (use full path): ");
        String dir = scn.next();

        FileSystem sys = new FileSystem(dir);

        MainInterface.RunMain(sys);

        scn.close();
    }
    
}
