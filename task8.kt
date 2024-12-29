fun main() {
  val number = 1234
  var sumOfDigits = 0
  var n = number

  while (n != 0) {
    sumOfDigits += n % 10
    n /= 10
  }

  println("Sum of digits of $number is: $sumOfDigits")
}
