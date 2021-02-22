package Phase1_Project;

public class Menu {

    private static String mainMenu = "       MAIN     \n-------------------\n1. List all files\n2. File operations\n3. Exit\n";
    private static String subMenu = "       SYSTEMS     \n---------------------\n1. Search for a file\n2. Add a new file\n3. Delete a current file\n4. Return to main menu\n";

    public static void DisplayMain()
    {
        System.out.println(mainMenu);
    }

    public static void DisplaySub()
    {
        System.out.println(subMenu);
    }
}
