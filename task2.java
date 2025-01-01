import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        // Specify the path of the input file
        File inputFile = new File("/Users/mariamtaplashvili/IdeaProjects/FOP_PROJECT/src/task2.kt");
        Integer N = null; // Variable to store the value of N

        // Try to read the file and extract the value of N
        try (Scanner scanner = new Scanner(inputFile)) {
            // Read the file line by line
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim(); // Trim whitespace from the line
                // Check if the line starts with "val N ="
                if (line.startsWith("val N =")) {
                    String[] parts = line.split("="); // Split the line at "="
                    if (parts.length == 2) {
                        // Parse the value after "=" into an integer
                        N = Integer.parseInt(parts[1].trim());
                    }
                    break; // Exit the loop once N is found
                }
            }
        } catch (FileNotFoundException e) {
            // Handle the case where the file is not found
            System.out.println("The file 'task2.kt' does not exist.");
            return;
        } catch (NumberFormatException e) {
            // Handle the case where the value of N is not a valid integer
            System.out.println("Invalid input. Please make sure the file contains a line with 'val N = <integer>'.");
            return;
        }

        // Check if N was successfully read and parsed
        if (N == null) {
            System.out.println("Invalid input. Please make sure the file contains a line with 'val N = <integer>'.");
            return;
        }

        // Calculate the factorial of N
        int factorial = 1;
        for (int i = 1; i <= N; i++) {
            factorial *= i; // Multiply the current factorial value by i
        }

        // Print the result
        System.out.println("Factorial of " + N + " is: " + factorial);
    }
}
