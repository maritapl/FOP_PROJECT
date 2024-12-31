// First, we import File and Scanner classes
import java.io.File;
import java.util.Scanner;

public class task8 {
    public static void main(String[] args) {
        // Here we retrieve values from the external file "task8.kt"
        try (Scanner scanner = new Scanner(new File("/Users/User/IdeaProjects/FOP/src/task8.kt"))) {
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
            // Now we start computing the sum of digits of the number
            int sumOfDigits = 0;
            int n = number;
            // The following loop will work until the value of n becomes 0
            while (n != 0) {
                // We add the last digit of the number to the sum
                sumOfDigits += n % 10;
                // Then we remove the last digit of the number and repeat the loop until the number becomes 0
                n /= 10;
            }

            // We print the sum of digits of the number
            System.out.println("Sum of digits of " + number + " is: " + sumOfDigits);
            // catch will handle exceptions 
        } catch (Exception e) {
            // The code will print the following if the program encounters an error while reading the file
            System.out.println("Error reading the file.");
        }
    }
}
