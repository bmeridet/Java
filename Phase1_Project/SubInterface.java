package Phase1_Project;

import java.util.Scanner;

public class SubInterface {

    public static void Run(FileSystem sys)
    {
        Scanner scn = new Scanner(System.in);
        Scanner fileName = new Scanner(System.in);
        String fName;

        Menu.DisplaySub();
        Integer input = scn.nextInt();

        while (input != 4)
        {
            switch (input)
            {
                case 1:
                {
                    System.out.println("Enter file name for search: ");
                    fName = fileName.next();
                    sys.FindFile(fName);

                    break;
                }
                case 2:
                {
                    System.out.println("Enter file name to add: ");
                    fName = fileName.next();
                    sys.AddFile(fName);

                    break;
                }
                case 3:
                {
                    System.out.println("Enter file name to delete: ");
                    fName = fileName.next();
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

        scn.close();
        fileName.close();
    }
    
}
