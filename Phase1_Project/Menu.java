package Phase1_Project;

public class Menu {

    private static String mainMenu = "1. List all files\n2. File operations\n3. Exit";
    private static String subMenu = "A. Search for a file\nB. Add a new file\nC. Delete a current file";

    public static void DisplayMain()
    {
        System.out.println(mainMenu);
    }

    public static void DisplaySub()
    {
        System.out.println(subMenu);
    }
}
