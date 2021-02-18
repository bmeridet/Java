package Phase1_Project;

import java.util.Scanner;

public class MainInterface {

    public static void Run(FileSystem sys)
    {
        Scanner scn = new Scanner(System.in);

        Menu.DisplayMain();
        Integer input = scn.nextInt();

        while (input != 3)
        {
            switch(input)
            {
                case 1:
                    sys.PrintFileList();
                    break;
                case 2:
                    SubInterface.Run(sys);
                    break;
                default:
                    System.out.println("Incorrect input.");
                    break;
            }

            Menu.DisplayMain();
            input = scn.nextInt();
        }

        System.out.println("Exiting. Goodbye!");

        scn.close();
    }
    
}
