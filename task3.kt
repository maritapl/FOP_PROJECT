fun main() {
    // Define two numbers for which we want to calculate the GCD
    val a = 48
    val b = 18

    // Initialize x and y with the values of a and b
    var x = a
    var y = b

    // Apply the Euclidean algorithm to find the Greatest Common Divisor (GCD)
    while (y != 0) {
        val temp = y
        y = x % y // Get the remainder when x is divided by y
        x = temp   // Assign the previous value of y to x
    }

    // Print the result: the GCD of a and b
    println("GCD of $a and $b is: $x")
}
