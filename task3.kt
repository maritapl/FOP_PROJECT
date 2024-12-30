fun main() {
    val a = 48
    val b = 18
    var x = a
    var y = b

    while (y != 0) {
        val temp = y
        y = x % y
        x = temp
    }

    println("GCD of $a and $b is: $x")
}
