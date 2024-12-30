class isPrime {
    fun main() {
        val number = 13
        var isPrime = true

        if (number <= 1) isPrime = false
        for (i in 2..number / 2) {
            if (number % i == 0) {
                isPrime = false
                break
            }
        }

        println("Is $number prime? $isPrime")
    }
}