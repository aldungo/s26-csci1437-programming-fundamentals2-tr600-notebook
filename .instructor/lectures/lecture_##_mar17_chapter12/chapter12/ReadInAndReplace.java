import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Main {
       public static void main(String[] args) {
              File file = new File("./src/MyFile.txt");
              File newFile = new File("./src/newFile.txt");
              System.out.println("Does it exist ? " + file.exists());

              try(Scanner inputFile = new Scanner(file);
                  PrintWriter outputFile = new PrintWriter(newFile)) {
                     for (int i = 0; i < 5; i++)
                     {
                            String token = inputFile.nextLine();
                            System.out.println(token);
                            if (token.equals("carrot"))
                            {
                                   token = "cantaloupe";
                                   outputFile.println(token);
                            }
                            else {
                                   outputFile.println(token);
                            }
                     }
              }
              catch (IOException ex)
              {
                     System.out.println("Something went wrong.");
              }
       }
}