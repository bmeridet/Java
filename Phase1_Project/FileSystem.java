package Phase1_Project;

import java.util.*;
import java.io.*;

public class FileSystem {

    private String dir;
    private Set<String> fileList;

    FileSystem(String _dir)
    {
        dir = _dir;
        fileList = new TreeSet<String>();
        ReadDir();
    }

    private void ReadDir()
    {
        // read files from specified dir into set fileList...
        File[] files = new File(dir).listFiles();

        for (File F : files)
        {
            fileList.add(F.getName());
        }
    }

    public boolean AddFile(String fName)
    {
        File f = new File(dir, fName);

        try
        {
            boolean result = f.createNewFile();
            if (result)
            {
                System.out.println("File added at location " + dir);
                return true;
            }
            else
            {
                System.out.println("File already exist at location " + dir);
                return false;
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }
    }

    public boolean DeleteFile(String fName)
    {
        File f = new File(dir, fName);

        if (f.delete())
        {
            System.out.println("Deleted " + fName);
            return true;
        }
        else
        {
            System.out.println("Unable to delete " + fName);
            return false;
        }
    }

    public boolean FindFile(String fName)
    {
        return fileList.contains(fName);
    }

    public String GetDir()
    {
        return dir;
    }

    public void PrintFileList()
    {
        System.out.println(fileList);
    }
    
}
