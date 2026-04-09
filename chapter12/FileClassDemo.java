import java.io.*;
import java.util.*;

public class FileClassDemo
{
    public static void main(String[] args)
    {
        File file = new File("MyTextFile.txt");
 

        if (file.exists())
        {
            System.out.println("This file is in your project.");
        }

        try 
        {
            PrintWriter outputFile = new PrintWriter(file);
            outputFile.println("Hello, world!");
        }
        catch(IOException e)
        {
            System.out.println("Something went wrong while writing to the file");
        }
        finally
        {
            outputFile.close();
        }

        /** same as above, but with TRY-WITH RESOURCES instead */
        try(PrintWriter outputFile = new PrintWriter(file)) // THIS RESOURCE AUTOMATICALLY CLOSES 
        {
            outputFile.println("Hello, world!");
        }
        catch (IOException e)
        {
            System.out.println("Something went wrong while writing to the file");
        }




    }
}
