fun main() {
    // Define the number for which we want to calculate the factorial
    val N = 5

    // Initialize the variable to store the factorial result
    var factorial = 1

    // Loop from 1 to N (inclusive) to calculate the factorial
    for (i in 1..N) {
        factorial *= i // Multiply the current value of factorial by i
    }

    // Print the result
    println("Factorial of $N is: $factorial")
}
