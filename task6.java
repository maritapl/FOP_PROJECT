import java.io.File;
import java.util.Scanner;

public class task6 {
    public static void main(String[] args) {
        // Try to open and read a file containing Kotlin code
        try (Scanner scanner = new Scanner(new File("/FOP_PROJECT/blob/Ana/task6.kt"))) {
            int number = 0;
            // Read the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                // Check if the line declares a number (e.g., "val number = 121")
                if (line.startsWith("val number =")) {
                    String[] parts = line.split("=");
                    if (parts.length == 2) {
                        // Extract the number from the line
                        number = Integer.parseInt(parts[1].trim());
                    }
                }
            }

            // Store the original number for comparison
            int original = number;
            int reversed = 0;
            // Reverse the digits of the number
            while (original != 0) {
                reversed = reversed * 10 + original % 10;
                original /= 10;
            }

            // Check if the number is the same when reversed
            boolean isPalindrome = number == reversed;
            // Print the result
            System.out.println("Is " + number + " a palindrome? " + isPalindrome);
        } catch (Exception e) {
            // Handle errors when reading the file
            System.out.println("Error reading the file.");
        }
    }
}

