import java.io.File;
import java.util.Scanner;

public class task8 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("/Users/User/IdeaProjects/FOP/src/task8.kt"))) {
            int number = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.startsWith("val number =")) {
                    String[] parts = line.split("=");
                    if (parts.length == 2) {
                        number = Integer.parseInt(parts[1].trim());
                    }
                }
            }

            int sumOfDigits = 0;
            int n = number;
            while (n != 0) {
                sumOfDigits += n % 10;
                n /= 10;
            }

            System.out.println("Sum of digits of " + number + " is: " + sumOfDigits);
        } catch (Exception e) {
            System.out.println("Error reading the file.");
        }
    }
}
