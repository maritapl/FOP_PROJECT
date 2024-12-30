import java.io.IO.println

class reverseNumber {
    fun main() {
        val number = 1234
        var reversed = 0
        var n = number

        while (n != 0) {
            reversed = reversed * 10 + n % 10
            n /= 10
        }

        println("Reversed number of $number is: $reversed")
    }
}