fun main() {
    // Declare a number to check
    val number = 3947
    // Variable to store the largest digit
    var largestDigit = 0
    var n = number

    // Find the largest digit in the number
    while (n != 0) {
        val digit = n % 10 // Get the last digit
        if (digit > largestDigit) largestDigit = digit // Update if the digit is larger
        n /= 10 // Remove the last digit
    }

    // Print the largest digit in the number
    println("The largest digit in $number is: $largestDigit")
}
