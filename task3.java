import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        // Specify the path of the input file
        File inputFile = new File("/Users/mariamtaplashvili/IdeaProjects/FOP_PROJECT/src/task3.kt");
        Integer a = null, b = null; // Variables to store values of a and b

        // Try to read the file and extract the values of a and b
        try (Scanner scanner = new Scanner(inputFile)) {
            // Read the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim(); // Trim any whitespace from the line
                // Check if the line starts with "val a ="
                if (line.startsWith("val a =")) {
                    String[] parts = line.split("="); // Split the line at "="
                    if (parts.length == 2) {
                        // Parse the value after "=" into an integer and assign it to a
                        a = Integer.parseInt(parts[1].trim());
                    }
                }
                // Check if the line starts with "val b ="
                if (line.startsWith("val b =")) {
                    String[] parts = line.split("="); // Split the line at "="
                    if (parts.length == 2) {
                        // Parse the value after "=" into an integer and assign it to b
                        b = Integer.parseInt(parts[1].trim());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            // Handle the case where the file is not found
            System.out.println("The file 'task3.kt' does not exist.");
            return;
        } catch (NumberFormatException e) {
            // Handle the case where the values of a or b are not valid integers
            System.out.println("Invalid input. Please make sure the file contains lines with 'val a = <integer>' and 'val b = <integer>'.");
            return;
        }

        // Check if a or b are not set (still null)
        if (a == null || b == null) {
            System.out.println("Invalid input. Please make sure the file contains 'val a = <integer>' and 'val b = <integer>'.");
            return;
        }

        // Initialize x and y with the values of a and b
        int x = a;
        int y = b;

        // Apply the Euclidean algorithm to find the Greatest Common Divisor (GCD)
        while (y != 0) {
            int temp = y;
            y = x % y;  // Get the remainder when x is divided by y
            x = temp;   // Assign the previous value of y to x
        }

        // Print the result: the GCD of a and b
        System.out.println("GCD of " + a + " and " + b + " is: " + x);
    }
}
