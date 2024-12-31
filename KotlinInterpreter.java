import java.util.*;

public class KotlinInterpreter { //KotlinInterpreter class: This class is designed to interpret and execute Kotlin code dynamically.
    private final Map<String, Integer> variables = new HashMap<>(); // Stores variables and their values.

    // Method to evaluate the given Kotlin-like code string.
    public void eval(String code) {
        String[] lines = code.split(";"); // Splitting the code into individual lines using the semicolon as a delimiter.
        for (String line : lines) { // Iterating over each line of the code.
            line = line.trim(); // Removing leading and trailing whitespace from the line.
            if (line.isEmpty()) continue; // Skipping empty lines.
            if (line.startsWith("val") || line.startsWith("var")) { // Handling immutable and mutable variable declarations.
                handleVariableDeclaration(line);
            } else if (line.startsWith("print")) { // Handling print statements.
                handlePrint(line);
            } else if (line.startsWith("algorithm")) { // Handling algorithm execution.
                handleAlgorithm(line);
            } else {
                System.out.println("Unknown command: " + line); // Handling unknown commands.
            }
        }
    }

    // Method to handle variable declarations.
    private void handleVariableDeclaration(String line) {
        boolean isImmutable = line.startsWith("val"); // Check if the declaration is immutable.
        String[] parts = line.split("="); // Splitting the line into the variable declaration and value using "=".
        if (parts.length == 2) {
            String declaration = parts[0].replace(isImmutable ? "val" : "var", "").trim(); // Extracting the declaration.
            String varName = declaration.split(":")[0].trim(); // Extracting the variable name.
            int value = Integer.parseInt(parts[1].trim()); // Parsing the assigned value as an integer.

            if (variables.containsKey(varName) && isImmutable) {
                System.out.println("Error: Cannot reassign immutable variable " + varName);
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
        if (variables.containsKey(expression)) {
            System.out.println(variables.get(expression)); // Printing the value of the variable if it exists.
        } else {
            System.out.println("Error: Unknown variable " + expression); // Printing an error if the variable does not exist.
        }
    }

    // Method to handle algorithm execution.
    private void handleAlgorithm(String line) {
        String algorithm = line.replace("algorithm", "").trim(); // Extracting the algorithm name.

        switch (algorithm) {
            case "sumFirstN" -> executeSumFirstN();
            case "factorial" -> executeFactorial();
            case "gcd" -> executeGCD();
            case "reverseNumber" -> executeReverseNumber();
            case "isPrime" -> executeIsPrime();
            case "isPalindrome" -> executeIsPalindrome();
            case "largestDigit" -> executeLargestDigit();
            case "sumOfDigits" -> executeSumOfDigits();
            case "multiplicationTable" -> executeMultiplicationTable();
            case "fibonacci" -> executeFibonacci();
            default -> System.out.println("Unknown algorithm: " + algorithm);
        }
    }

    private void executeSumFirstN() {
        int n = variables.getOrDefault("N", 0);
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println("Sum of first " + n + " numbers: " + sum);
    }

    private void executeFactorial() {
        int n = variables.getOrDefault("N", 0);
        int fact = 1;
        for (int i = 2; i <= n; i++) {
            fact *= i;
        }
        System.out.println("Factorial of " + n + ": " + fact);
    }

    private void executeGCD() {
        int a = variables.getOrDefault("A", 0);
        int b = variables.getOrDefault("B", 0);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        System.out.println("GCD: " + a);
    }

    private void executeReverseNumber() {
        int num = variables.getOrDefault("NUM", 0);
        int reversed = 0;
        while (num != 0) {
            reversed = reversed * 10 + num % 10;
            num /= 10;
        }
        System.out.println("Reversed number: " + reversed);
    }

    private void executeIsPrime() {
        int num = variables.getOrDefault("NUM", 0);
        if (num < 2) {
            System.out.println(num + " is not prime.");
            return;
        }
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                System.out.println(num + " is not prime.");
                return;
            }
        }
        System.out.println(num + " is prime.");
    }

    private void executeIsPalindrome() {
        int num = variables.getOrDefault("NUM", 0);
        String original = Integer.toString(num);
        String reversed = new StringBuilder(original).reverse().toString();
        System.out.println(num + " is palindrome: " + original.equals(reversed));
    }

    private void executeLargestDigit() {
        int num = variables.getOrDefault("NUM", 0);
        int largest = 0;
        while (num != 0) {
            largest = Math.max(largest, num % 10);
            num /= 10;
        }
        System.out.println("Largest digit: " + largest);
    }

    private void executeSumOfDigits() {
        int num = variables.getOrDefault("NUM", 0);
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        System.out.println("Sum of digits: " + sum);
    }

    private void executeMultiplicationTable() {
        int num = variables.getOrDefault("NUM", 0);
        System.out.println("Multiplication Table for " + num + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(num * i);
        }
    }

    private void executeFibonacci() {
        int n = variables.getOrDefault("N", 0);
        if (n <= 0) {
            System.out.println("Invalid N.");
            return;
        }
        int a = 0, b = 1;
        for (int i = 2; i < n; i++) {
            int temp = b;
            b = a + b;
            a = temp;
        }
        System.out.println("Fibonacci number " + n + ": " + b);
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
