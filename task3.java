import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        File inputFile = new File("/Users/mariamtaplashvili/IdeaProjects/FOP_PROJECT/src/task3.kt");
        Integer a = null, b = null;

        try (Scanner scanner = new Scanner(inputFile)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine().trim();
                if (line.startsWith("val a =")) {
                    String[] parts = line.split("=");
                    if (parts.length == 2) {
                        a = Integer.parseInt(parts[1].trim());
                    }
                }
                if (line.startsWith("val b =")) {
                    String[] parts = line.split("=");
                    if (parts.length == 2) {
                        b = Integer.parseInt(parts[1].trim());
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("The file 'task3.kt' does not exist.");
            return;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input. Please make sure the file contains lines with 'val a = <integer>' and 'val b = <integer>'.");
            return;
        }

        if (a == null || b == null) {
            System.out.println("Invalid input. Please make sure the file contains 'val a = <integer>' and 'val b = <integer>'.");
            return;
        }
        int x = a;
        int y = b;
        while (y != 0) {
            int temp = y;
            y = x % y;
            x = temp;
        }
        System.out.println("GCD of " + a + " and " + b + " is: " + x);
    }
}

