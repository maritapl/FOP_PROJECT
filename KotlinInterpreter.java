import java.util.*; // Importing the utility package for using collections like Map and HashMap.

public class KotlinInterpreter { // KotlinInterpreter class: This class is designed to interpret and execute Kotlin code dynamically.
    private final Map<String, Integer> variables = new HashMap<>(); // Stores variables and their values.

    // Method to evaluate the given Kotlin-like code string.
    public void eval(String code) {
        String[] lines = code.split(";"); // Splitting the code into individual lines using the semicolon as a delimiter.
        for (String line : lines) { // Iterating over each line of the code.
            line = line.trim(); // Removing leading and trailing whitespace from the line.
            if (line.isEmpty()) continue; // Skipping empty lines.
            if (line.startsWith("val") || line.startsWith("var")) { // Handling immutable and mutable variable declarations.
                handleVariableDeclaration(line); // Calling the method to handle variable declarations.
            } else if (line.startsWith("print")) { // Handling print statements.
                handlePrint(line); // Calling the method to handle print statements.
            } else if (line.startsWith("algorithm")) { // Handling algorithm execution.
                handleAlgorithm(line); // Calling the method to execute algorithms.
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

            if (variables.containsKey(varName) && isImmutable) { // Checking if an immutable variable is being reassigned.
                System.out.println("Error: Cannot reassign immutable variable " + varName); // Printing an error for reassignment.
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

        // Executing the appropriate algorithm based on the name.
        switch (algorithm) {
            case "sumFirstN" -> executeSumFirstN(); // Executes the sum of the first N numbers.
            case "factorial" -> executeFactorial(); // Executes the factorial calculation.
            case "gcd" -> executeGCD(); // Executes the greatest common divisor calculation.
            case "reverseNumber" -> executeReverseNumber(); // Executes the number reversal algorithm.
            case "isPrime" -> executeIsPrime(); // Executes the prime number check.
            case "isPalindrome" -> executeIsPalindrome(); // Executes the palindrome check.
            case "largestDigit" -> executeLargestDigit(); // Executes the largest digit finder.
            case "sumOfDigits" -> executeSumOfDigits(); // Executes the sum of digits calculation.
            case "multiplicationTable" -> executeMultiplicationTable(); // Executes the multiplication table generation.
            case "fibonacci" -> executeFibonacci(); // Executes the Fibonacci sequence generation.
            default -> System.out.println("Unknown algorithm: " + algorithm); // Handles unknown algorithms.
        }
    }

    // ... (Algorithm methods with comments are already present in the previous code snippet)

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