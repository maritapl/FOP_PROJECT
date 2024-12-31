import java.io.File;
import java.util.Scanner;

public class task7 {
    public static void main(String[] args) {
        // Try to open and read a file containing Kotlin code
        try (Scanner scanner = new Scanner(new File("/FOP_PROJECT/blob/Ana/task6.kt"))) {
            int number = 0;
            // Read the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                // Check if the line declares a number (e.g., "val number = 3947")
                if (line.startsWith("val number =")) {
                    String[] parts = line.split("=");
                    if (parts.length == 2) {
                        // Extract the number from the line
                        number = Integer.parseInt(parts[1].trim());
                    }
                }
            }

            // Find the largest digit in the number
            int largestDigit = 0;
            int n = number;
            while (n != 0) {
                int digit = n % 10; // Get the last digit
                if (digit > largestDigit) largestDigit = digit; // Update if the digit is larger
                n /= 10; // Remove the last digit
            }

            // Print the largest digit in the number
            System.out.println("The largest digit in " + number + " is: " + largestDigit);
        } catch (Exception e) {
            // Handle errors when reading the file
            System.out.println("Error reading the file.");
        }
    }
}

