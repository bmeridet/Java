package FileHandling;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.*; 

public class CreateFile {
    
    public static void main(String[] args) throws IOException
    {
        CreateFileUsingFileClass();
        CreateFileUsingFileOutputStreamClass();
        CreateFileIn_NIO();
    }

    public static void CreateFileUsingFileClass() throws IOException
    {
        File f = new File("this.txt");

        if (f.createNewFile())
            System.out.println("File created.");
        else
            System.out.println("File already exists.");

        FileWriter fw = new FileWriter(f);
        fw.write("Hello World from this file.");
        fw.close();
    }

    public static void CreateFileUsingFileOutputStreamClass() throws IOException
    {
        String data = "Test data";

        FileOutputStream fo = new FileOutputStream("this2.txt");
        fo.write(data.getBytes());
        fo.close();
    }

    public static void CreateFileIn_NIO() throws IOException
    {
        String data = "Test data";
        Files.write(Paths.get("this3.txt"), data.getBytes());
        List<String> lines = Arrays.asList("1st line", "2nd line");
        Files.write(Paths.get("this4.txt"), lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
    }
}
