public class Main {
    public static void main(String[] args) {
    }
    public static void reverseNumber(String code) {
        int number = 0;
        String[] lines = code.split("\n");
        for (String line : lines) {
            if (line.startsWith("var number")) {
                number = Integer.parseInt(line.split("=")[1].trim());
            }
        }
        int reversed = 0;
        while (number != 0) {
            int digit = number % 10;
            reversed = reversed * 10 + digit;
            number /= 10;
        }

        System.out.println("Reversed number: " + reversed);
    }

    public static void isPrime(String code) {
        int number = 0;
        String[] lines = code.split("\n");
        for (String line : lines) {
            if (line.startsWith("var number")) {
                number = Integer.parseInt(line.split("=")[1].trim());
            }
        }

        boolean isPrime = true;
        if (number <= 1) {
            isPrime = false;
        } else {
            for (int i = 2; i <= Math.sqrt(number); i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }
        }
        System.out.println("Is number prime: " + isPrime);
    }
}
