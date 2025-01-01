fun main() {
    // Define the number of natural numbers to sum
    val N = 10
    
    // Initialize the variable to store the sum
    var sum = 0
    
    // Loop from 1 to N (inclusive) and add each number to the sum
    for (i in 1..N) {
        sum += i
    }
    
    // Print the result
    println("Sum of the first $N natural numbers is: $sum")
}
