package Phase1_Project;

import java.util.Scanner;

public class FileMain {

    public static final Scanner scn = new Scanner(System.in);

    public static void main (String[] args)
    {
        FileSystem sys = new FileSystem("C:/Users/benja/projects/java/Phase1_Project/Data");

        MainInterface.RunMain(sys);

        scn.close();
    }
    
}
