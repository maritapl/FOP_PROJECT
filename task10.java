import java.io.File;
import java.util.Scanner;

public class task10 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("/Users/User/IdeaProjects/FOP/src/task10.kt"))) {
            int n = 0;
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.startsWith("val n =")) {
                    String[] parts = line.split("=");
                    if (parts.length == 2) {
                        n = Integer.parseInt(parts[1].trim());
                    }
                }
            }

            int a = 0, b = 1;
            for (int i = 2; i <= n; i++) {
                int next = a + b;
                a = b;
                b = next;
            }


            System.out.println("The " + n + "-th Fibonacci number is: " + b);
        } catch (Exception e) {
            System.out.println("Error reading the file.");
        }
    }
}
