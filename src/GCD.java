import java.util.Scanner;

public class GCD {
    public static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Take user input for two integers
        System.out.print("Enter the first number: ");
        int a = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int b = scanner.nextInt();

        // Calculate and print the GCD
        int gcd = findGCD(a, b);
        System.out.println("The GCD of " + a + " and " + b + " is: " + gcd);

        scanner.close();
    }
}
