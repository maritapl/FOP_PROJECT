import java.io.File;
import java.util.Scanner;

public class task9 {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(new File("/Users/User/IdeaProjects/FOP/src/task9.kt"))) {
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

            for (int i = 1; i <= 10; i++) {
                System.out.println(number + " x " + i + " = " + (number * i));
            }
        } catch (Exception e) {
            System.out.println("Error reading the file.");
        }
    }
}
