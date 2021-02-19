package Phase1_Project;

import java.util.Scanner;

public class MainInterface {

    private static Scanner scn = new Scanner(System.in);

    public static void RunMain(FileSystem sys)
    {
        Menu.DisplayMain();
        Integer input = scn.nextInt();

        while (input != 3)
        {
            switch(input)
            {
                case 1:
                {
                    sys.PrintFileList();
                    break;
                }
                case 2:
                {
                    RunSub(sys);
                    break;
                }
                default:
                {
                    System.out.println("Incorrect input.");
                    break;
                }
            }

            Menu.DisplayMain();
            input = scn.nextInt();
        }

        System.out.println("Exiting. Goodbye!");
        scn.close();
    }

    private static void RunSub(FileSystem sys)
    {
        Menu.DisplaySub();
        Integer input = scn.nextInt();
        String fName;

        while (input != 4)
        {
            switch (input)
            {
                case 1:
                {
                    System.out.println("Enter file name for search: ");
                    fName = scn.next();
                    sys.FindFile(fName);

                    break;
                }
                case 2:
                {
                    System.out.println("Enter file name to add: ");
                    fName = scn.next();
                    sys.AddFile(fName);

                    break;
                }
                case 3:
                {
                    System.out.println("Enter file name to delete: ");
                    fName = scn.next();
                    sys.DeleteFile(fName);

                    break;
                }
                case 4:
                {
                    System.out.println("Returning to main menu.");
                    break;
                }
                default:
                    break;
            }

            Menu.DisplaySub();
            input = scn.nextInt();
        }

    }
    
}
