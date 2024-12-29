fun main() {
    val number = 121
    var original = number
    var reversed = 0

    while (original != 0) {
        reversed = reversed * 10 + original % 10
        original /= 10
    }

    val isPalindrome = number == reversed
    println("Is $number a palindrome? $isPalindrome")
}
