// First, we import File and Scanner classes
import java.io.File;
import java.util.Scanner;

public class task10 {
    public static void main(String[] args) {
        // Here we retrieve values from the external file "task10.kt"
        try (Scanner scanner = new Scanner(new File("/Users/User/IdeaProjects/FOP/src/task10.kt"))) {
            // We declare a variable to store the number from the external file
            int n = 0;
            // The following loop reads the file line by line
            while (scanner.hasNextLine()) {
                // To avoid whitespaces, we trim them from each line
                String line = scanner.nextLine().trim();
                // The following "if" statement checks if the line defines a number
                if (line.startsWith("val n =")) {
                    // Here we are splitting the line to isolate the number value
                    String[] parts = line.split("=");
                    // Here the code makes sure that the line is split
                    if (parts.length == 2) {
                        // We convert the value from string to int
                        n = Integer.parseInt(parts[1].trim());
                    }
                }
            }

            // Now we start computing n-th fibonacci number
            int a = 0, b = 1;

            // The loop compute the fibonacci sequence
            for (int i = 2; i <= n; i++) {
                // The following calculates the next fibonacci number by summing the previous two numbers
                int next = a + b;
                // Next, we update a and b and repeat the loop
                a = b;
                b = next;
            }

            // We print the n-th fibonacci number
            System.out.println("The " + n + "-th Fibonacci number is: " + b);
        // catch will handle exceptions
        } catch (Exception e) {
            // The code will print the following if the program encounters an error while reading the file
            System.out.println("Error reading the file.");
        }
    }
}
