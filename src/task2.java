import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class task2 {
    public static void main(String[] args) {
        File inputFile = new File("/Users/mariamtaplashvili/IdeaProjects/FOP_PROJECT/src/task2.kt");
        Integer N = null;

        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.startsWith("val N =")) {
                    String[] parts = line.split("=");
                    if (parts.length == 2) {
                        N = Integer.parseInt(parts[1].trim());
                    }
                    break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file 'task2.kt' does not exist.");
            return;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please make sure the file contains a line with 'val N = <integer>'.");
            return;
        }

        if (N == null) {
            System.out.println("Invalid input. Please make sure the file contains a line with 'val N = <integer>'.");
            return;
        }

        int factorial = 1;
        for (int i = 1; i <= N; i++) {
            factorial *= i;
        }


        System.out.println("Factorial of " + N + " is: " + factorial);
    }
}