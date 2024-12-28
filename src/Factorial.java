import java.util.Scanner;

public class Factorial {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);


            System.out.print("Enter a number to calculate its factorial: ");
            int N = scanner.nextInt();


            if (N < 0) {
                System.out.println("Factorial is not defined for negative numbers.gooood boyyyyyy   ");
            } else {

                long factorial = 1;
                for (int i = 1; i <= N; i++) {
                    factorial *= i;
                }


                System.out.println("The factorial of " + N + " is: " + factorial);
            }

            scanner.close();
        }
    }

