import java.util.*; // Importing the utility package for using Map and other utilities.

public class KotlinInterpreter { // KotlinInterpreter class: This class is designed to interpret and execute Kotlin-like code dynamically.
    private final Map<String, Integer> variables = new HashMap<>(); // Stores variables and their values.

    // Method to evaluate the given Kotlin-like code string.
    public void eval(String code) {
        String[] lines = code.split(";"); // Splitting the code into individual lines using the semicolon as a delimiter.
        for (String line : lines) { // Iterating over each line of the code.
            line = line.trim(); // Removing leading and trailing whitespace from the line.
            if (line.isEmpty()) continue; // Skipping empty lines.
            if (line.startsWith("val") || line.startsWith("var")) { // Handling immutable and mutable variable declarations.
                handleVariableDeclaration(line); // Processing the variable declaration line.
            } else if (line.startsWith("print")) { // Handling print statements.
                handlePrint(line); // Processing the print statement.
            } else if (line.startsWith("algorithm")) { // Handling algorithm execution.
                handleAlgorithm(line); // Processing the algorithm execution line.
            } else {
                System.out.println("Unknown command: " + line); // Handling unknown commands.
            }
        }
    }

    // Method to handle variable declarations.
    private void handleVariableDeclaration(String line) {
        boolean isImmutable = line.startsWith("val"); // Check if the declaration is immutable.
        String[] parts = line.split("="); // Splitting the line into the variable declaration and value using "=".
        if (parts.length == 2) { // Ensuring the declaration has both a variable and a value.
            String declaration = parts[0].replace(isImmutable ? "val" : "var", "").trim(); // Extracting the declaration.
            String varName = declaration.split(":")[0].trim(); // Extracting the variable name.
            int value = Integer.parseInt(parts[1].trim()); // Parsing the assigned value as an integer.

            if (variables.containsKey(varName) && isImmutable) { // Checking if the variable is immutable and already exists.
                System.out.println("Error: Cannot reassign immutable variable " + varName); // Printing an error message.
            } else {
                variables.put(varName, value); // Storing the variable and its value in the map.
            }
        } else {
            System.out.println("Invalid variable declaration: " + line); // Printing an error message for invalid declarations.
        }
    }

    // Method to handle print statements.
    private void handlePrint(String line) {
        String expression = line.replace("print", "").trim(); // Extracting the expression to print.
        if (variables.containsKey(expression)) { // Checking if the variable exists.
            System.out.println(variables.get(expression)); // Printing the value of the variable if it exists.
        } else {
            System.out.println("Error: Unknown variable " + expression); // Printing an error if the variable does not exist.
        }
    }

    // Method to handle algorithm execution.
    private void handleAlgorithm(String line) {
        String algorithm = line.replace("algorithm", "").trim(); // Extracting the algorithm name.

        switch (algorithm) { // Matching the algorithm name to the appropriate method.
            case "sumFirstN" -> executeSumFirstN(); // Executes the sum of the first N numbers.
            case "factorial" -> executeFactorial(); // Executes the factorial calculation.
            case "gcd" -> executeGCD(); // Executes the GCD calculation.
            case "reverseNumber" -> executeReverseNumber(); // Executes the number reversal.
            case "isPrime" -> executeIsPrime(); // Executes the prime check.
            case "isPalindrome" -> executeIsPalindrome(); // Executes the palindrome check.
            case "largestDigit" -> executeLargestDigit(); // Executes the largest digit calculation.
            case "sumOfDigits" -> executeSumOfDigits(); // Executes the sum of digits calculation.
            case "multiplicationTable" -> executeMultiplicationTable(); // Executes the multiplication table generation.
            case "fibonacci" -> executeFibonacci(); // Executes the Fibonacci sequence calculation.
            default -> System.out.println("Unknown algorithm: " + algorithm); // Handling unknown algorithms.
        }
    }

    // Method to calculate the sum of the first N numbers.
    private void executeSumFirstN() {
        int n = variables.getOrDefault("N", 0); // Getting the value of N or defaulting to 0.
        int sum = 0; // Initializing the sum.
        for (int i = 1; i <= n; i++) { // Iterating from 1 to N.
            sum += i; // Adding each number to the sum.
        }
        System.out.println("Sum of first " + n + " numbers: " + sum); // Printing the result.
    }

    // Method to calculate the factorial of a number.
    private void executeFactorial() {
        int n = variables.getOrDefault("N", 0); // Getting the value of N or defaulting to 0.
        int fact = 1; // Initializing the factorial.
        for (int i = 2; i <= n; i++) { // Iterating from 2 to N.
            fact *= i; // Multiplying each number to the factorial.
        }
        System.out.println("Factorial of " + n + ": " + fact); // Printing the result.
    }

    // Method to calculate the GCD of two numbers.
    private void executeGCD() {
        int a = variables.getOrDefault("A", 0); // Getting the value of A or defaulting to 0.
        int b = variables.getOrDefault("B", 0); // Getting the value of B or defaulting to 0.
        while (b != 0) { // Loop until B becomes 0.
            int temp = b; // Storing B temporarily.
            b = a % b; // Updating B to the remainder of A divided by B.
            a = temp; // Updating A to the old value of B.
        }
        System.out.println("GCD: " + a); // Printing the result.
    }

    // Method to reverse a number.
    private void executeReverseNumber() {
        int num = variables.getOrDefault("NUM", 0); // Getting the value of NUM or defaulting to 0.
        int reversed = 0; // Initializing the reversed number.
        while (num != 0) { // Loop until the number becomes 0.
            reversed = reversed * 10 + num % 10; // Extracting and appending the last digit.
            num /= 10; // Removing the last digit from the number.
        }
        System.out.println("Reversed number: " + reversed); // Printing the result.
    }

    // Method to check if a number is prime.
    private void executeIsPrime() {
        int num = variables.getOrDefault("NUM", 0); // Getting the value of NUM or defaulting to 0.
        if (num < 2) { // Checking if the number is less than 2.
            System.out.println(num + " is not prime."); // Printing the result.
            return; // Exiting the method.
        }
        for (int i = 2; i * i <= num; i++) { // Checking divisors up to the square root of the number.
            if (num % i == 0) { // If a divisor is found.
                System.out.println(num + " is not prime."); // Printing the result.
                return; // Exiting the method.
            }
        }
        System.out.println(num + " is prime."); // Printing the result if no divisors are found.
    }

    // Method to check if a number is a palindrome.
    private void executeIsPalindrome() {
        int num = variables.getOrDefault("NUM", 0); // Getting the value of NUM or defaulting to 0.
        String original = Integer.toString(num); // Converting the number to a string.
        String reversed = new StringBuilder(original).reverse().toString(); // Reversing the string.
        System.out.println(num + " is palindrome: " + original.equals(reversed)); // Printing the result.
    }

    // Method to find the largest digit in a number.
    private void executeLargestDigit() {
        int num = variables.getOrDefault("NUM", 0); // Getting the value of NUM or defaulting to 0.
        int largest = 0; // Initializing the largest digit.
        while (num != 0) { // Loop until the number becomes 0.
            largest = Math.max(largest, num % 10); // Updating the largest digit if the current digit is greater.
            num /= 10; // Removing the last digit from the number.
        }
        System.out.println("Largest digit: " + largest); // Printing the result.
    }

    // Method to calculate the sum of digits of a number.
    private void executeSumOfDigits() {
        int num = variables.getOrDefault("NUM", 0); // Getting the value of NUM or defaulting to 0.
        int sum = 0; // Initializing the sum of digits.
        while (num != 0) { // Loop until the number becomes 0.
            sum += num % 10; // Adding the last digit to the sum.
            num /= 10; // Removing the last digit from the number.
        }
        System.out.println("Sum of digits: " + sum); // Printing the result.
    }

    // Method to print the multiplication table of a number.
    private void executeMultiplicationTable() {
        int num = variables.getOrDefault("NUM", 0); // Getting the value of NUM or defaulting to 0.
        System.out.println("Multiplication Table for " + num + ":"); // Printing the header.
        for (int i = 1; i <= 10; i++) { // Looping from 1 to 10.
            System.out.println(num * i); // Printing each product.
        }
    }

    // Method to calculate the Nth Fibonacci number.
    private void executeFibonacci() {
        int n = variables.getOrDefault("N", 0); // Getting the value of N or defaulting to 0.
        if (n <= 0) { // Checking if N is valid.
            System.out.println("Invalid N."); // Printing an error message.
            return; // Exiting the method.
        }
        int a = 0, b = 1; // Initializing the first two Fibonacci numbers.
        for (int i = 2; i < n; i++) { // Looping to calculate the Nth Fibonacci number.
            int temp = b; // Storing the current value of B temporarily.
            b = a + b; // Calculating the next Fibonacci number.
            a = temp; // Updating A to the old value of B.
        }
        System.out.println("Fibonacci number " + n + ": " + b); // Printing the result.
    }

    public static void main(String[] args) { // Main method to run the interpreter.
        KotlinInterpreter interpreter = new KotlinInterpreter(); // Creating an instance of KotlinInterpreter.

        String program = """
            var N: Int = 10;
            algorithm sumFirstN;
            var N: Int = 5;
            algorithm factorial;
            var A: Int = 48;
            var B: Int = 18;
            algorithm gcd;
            var NUM: Int = 1234;
            algorithm reverseNumber;
            var NUM: Int = 13;
            algorithm isPrime;
            var NUM: Int = 121;
            algorithm isPalindrome;
            var NUM: Int = 3947;
            algorithm largestDigit;
            var NUM: Int = 1234;
            algorithm sumOfDigits;
            var NUM: Int = 5;
            algorithm multiplicationTable;
            var N: Int = 10;
            algorithm fibonacci;
        """; // Defining a program string containing variable declarations, algorithm calls, and print statements.

        interpreter.eval(program); // Evaluating the program using the interpreter.
    }
}
