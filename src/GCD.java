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

        System.out.print("Enter the first number: ");
        int a = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int b = scanner.nextInt();

        int gcd = findGCD(a, b);
        System.out.println("The GCD of " + a + " and " + b + " is: " + gcd);

        scanner.close();
    }
}
