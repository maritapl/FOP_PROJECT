import java.util.*;

public class SimpleInterpreter{
    private final Map<String, Integer> variables = new HashMap<>();

    public void eval(String code) {
        String[] lines = code.split(";");
        for (String line : lines) {
            line = line.trim();
            if (line.isEmpty()) continue;
            if (line.startsWith("val")) {
                handleAssignment(line);
            }
            else if (line.startsWith("algorithm")) {
                handleAlgorithm(line);
            }
        }
    }

    private void handleAssignment(String line) {
        String[] parts = line.split("=");
        if (parts.length == 2) {
            String varName = parts[0].replace("val", "").trim();
            int value = Integer.parseInt(parts[1].trim());
            variables.put(varName, value);
        } else {
            System.out.println("Invalid assignment: " + line);
        }
    }

    private void handleAlgorithm(String line) {
        String algorithm = line.replace("algorithm", "").trim();

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

    public static void main(String[] args) {
        SimpleInterpreter interpreter = new SimpleInterpreter();

        String program = """
            val N = 10;
            algorithm sumFirstN;
            val N = 5;
            algorithm factorial;
            val A = 48;
            val B = 18;
            algorithm gcd;
            val NUM = 1234;
            algorithm reverseNumber;
            val NUM = 13;
            algorithm isPrime;
            val NUM = 121;
            algorithm isPalindrome;
            val NUM = 3947;
            algorithm largestDigit;
            val NUM = 1234;
            algorithm sumOfDigits;
            val NUM = 5;
            algorithm multiplicationTable;
            val N = 10;
            algorithm fibonacci;
        """;

        interpreter.eval(program);
    }
}