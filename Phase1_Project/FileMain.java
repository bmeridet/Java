package Phase1_Project;

import java.io.InputStream;
import java.util.Scanner;

public class FileMain {

    public static void main (String[] args)
    {
        FileSystem sys = new FileSystem("C:/Users/benja/projects/java/Phase1_Project/Data");
        sys.PrintFileList();
        //System.out.println("Search Result: " + sys.FindFile("red.txt"));
        //System.out.println("Add file result: " + sys.AddFile("red.txt"));
        //System.out.println("Delete file result: " + sys.DeleteFile("red.txt"));

        Menu.DisplayMain();
        Menu.DisplaySub();
    }
    
}
