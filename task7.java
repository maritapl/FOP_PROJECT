import java.io.File;
import java.util.Scanner;

public class task7 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("/FOP_PROJECT/blob/Ana/task6.kt"))) {
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

            int largestDigit = 0;
            int n = number;
            while (n != 0) {
                int digit = n % 10;
                if (digit > largestDigit) largestDigit = digit;
                n /= 10;
            }

            System.out.println("The largest digit in " + number + " is: " + largestDigit);
        } catch (Exception e) {
            System.out.println("Error reading the file.");
        }
    }
}
