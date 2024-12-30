import java.io.IO.println
class ReverseNumber {
    // Entry point of the program
    fun main() {
        // Original number to be reversed
        val number = 1234
        // Variable to store the reversed number
        var reversed = 0
        // Temporary variable to hold the current number during reversal
        var n = number
        // Loop until all digits are processed
        while (n != 0) {
            // Extract the last digit of the current number and add it to the reversed number
            reversed = reversed * 10 + n % 10
            // Remove the last digit from the current number
            n /= 10
        }
        // Print the reversed number
        println("Reversed number of $number is: $reversed")
    }
}