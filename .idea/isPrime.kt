fun main() {
    val number = 13 // The number to check for primality
    var isPrime = true // Assume the number is prime

    // If the number is <= 1, it's not prime
    if (number <= 1) {
        isPrime = false
    } else {
        // Check if the number is divisible by any number
        for (i in 2..number / 2) {
            if (number % i == 0) { // If divisible without a remainder
                isPrime = false // The number is not prime
                break // Exit the loop
            }
        }
    }

    // Print whether the number is prime
    println("Is $number a prime number? $isPrime")
}