import java.util.Scanner;

    public class SumOfNumbers {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a number (N): ");
            int n = scanner.nextInt();
            int sum = 0;

            for (int i = 1; i <= n; i++) {
                sum += i;
            }

            System.out.println("Sum of first " + n + " numbers is: " + sum);
            scanner.close();
        }
    }


