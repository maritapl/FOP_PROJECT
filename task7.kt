fun main() {
    val number = 3947
    var largestDigit = 0
    var n = number

    while (n != 0) {
        val digit = n % 10
        if (digit > largestDigit) largestDigit = digit
        n /= 10
    }

    println("The largest digit in $number is: $largestDigit")
}
