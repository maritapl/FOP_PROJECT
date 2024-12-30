fun main() {
    // Declare a number to check
    val number = 121
    // Store the original number for comparison
    var original = number
    var reversed = 0

    // Reverse the digits of the number
    while (original != 0) {
        reversed = reversed * 10 + original % 10
        original /= 10
    }

    // Check if the number is the same when reversed
    val isPalindrome = number == reversed
    // Print the result
    println("Is $number a palindrome? $isPalindrome")
}
