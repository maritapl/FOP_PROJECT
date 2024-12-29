fun main() {
    val N = 5
    var factorial = 1
    for (i in 1..N) {
        factorial *= i
    }
    println("Factorial of $N is: $factorial")
}