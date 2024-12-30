fun main() {
    val n = 10
    var a = 0
    var b = 1

    for (i in 2..n) {
        val next = a + b
        a = b
        b = next
    }

    println("The $n-th Fibonacci number is: $b")
}
