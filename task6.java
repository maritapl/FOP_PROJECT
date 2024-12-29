import java.io.File;
import java.util.Scanner;

public class task6 {
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

            int original = number;
            int reversed = 0;
            while (original != 0) {
                reversed = reversed * 10 + original % 10;
                original /= 10;
            }

            boolean isPalindrome = number == reversed;
            System.out.println("Is " + number + " a palindrome? " + isPalindrome);
        } catch (Exception e) {
            System.out.println("Error reading the file.");
        }
    }
}
