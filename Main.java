public class Main {
    public static void main(String[] args) {
        // No implementation inside main; methods should be called here if needed
    }

    // Method to reverse the number extracted from the given code
    public static void reverseNumber(String code) {
        int number = 0; // Variable to store the extracted number

        // Split the input code into lines
        String[] lines = code.split("\n");

        // Loop through each line of the code to find the variable declaration
        for (String line : lines) {
            // Check if the line declares the variable "number"
            if (line.startsWith("var number")) {
                // Extract the number by splitting the line and parsing the value
                number = Integer.parseInt(line.split("=")[1].trim());
            }
        }

        int reversed = 0; // Variable to store the reversed number

        // Logic to reverse the digits of the number
        while (number != 0) {
            int digit = number % 10; // Extract the last digit
            reversed = reversed * 10 + digit; // Add the digit to the reversed number
            number /= 10; // Remove the last digit from the original number
        }

        // Print the reversed number
        System.out.println("Reversed number: " + reversed);
    }

    // Method to check if the number extracted from the given code is prime
    public static void isPrime(String code) {
        int number = 0; // Variable to store the extracted number

        // Split the input code into lines
        String[] lines = code.split("\n");

        // Loop through each line of the code to find the variable declaration
        for (String line : lines) {
            // Check if the line declares the variable "number"
            if (line.startsWith("var number")) {
                // Extract the number by splitting the line and parsing the value
                number = Integer.parseInt(line.split("=")[1].trim());
            }
        }

        boolean isPrime = true; // Flag to determine if the number is prime

        // Check for edge cases (numbers less than or equal to 1 are not prime)
        if (number <= 1) {
            isPrime = false;
        } else {
            // Check divisors from 2 to the square root of the number
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) { // If the number is divisible by any i, it's not prime
                    isPrime = false;
                    break; // Exit the loop early since we found a divisor
                }
            }
        }

        // Print whether the number is prime
        System.out.println("Is number prime: " + isPrime);
    }
}
