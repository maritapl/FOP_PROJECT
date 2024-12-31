// First, we import File and Scanner classes
import java.io.File;
import java.util.Scanner;

public class task9 {
    public static void main(String[] args) {
        // Here we retrieve values from the external file "task9.kt"
        try (Scanner scanner = new Scanner(new File("/Users/User/IdeaProjects/FOP/src/task9.kt"))) {
            // We declare a variable to store the number from the external file
            int number = 0;
            // The following loop reads the file line by line
            while (scanner.hasNextLine()) {
                // To avoid whitespaces, we trim them from each line
                String line = scanner.nextLine().trim();
                // The following "if" statement checks if the line defines a number
                if (line.startsWith("val number =")) {
                    // Here we are splitting the line to isolate the number value
                    String[] parts = line.split("=");
                    // Here the code makes sure that the line is split
                    if (parts.length == 2) {
                        // We convert the value from string to int
                        number = Integer.parseInt(parts[1].trim());
                    }
                }
            }

            // Now we start making a multiplication table for the number from the kotlin file
            for (int i = 1; i <= 10; i++) {
                // We print a multiplication table for the number
                System.out.println(number + " x " + i + " = " + (number * i));
            }
            // catch will handle exceptions
        } catch (Exception e) {
            // The code will print the following if the program encounters an error while reading the file
            System.out.println("Error reading the file.");
        }
    }
}
