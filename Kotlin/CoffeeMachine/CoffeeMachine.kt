fun main() {
    println("Welcome to the coffee shop. What is your name? (Enter your name below.)")
    println("My name is:")
    var nameInput : String = readln()
    println("Hello, $nameInput. How many pieces of sugar would you like?")
    println("I would like: ")
    var sugarInput : Int = readln().toInt()
    makeCoffee(nameInput,sugarInput)
}

fun makeCoffee(name : String, sugarCount : Int)
{
    if(sugarCount == 1){
        println("Coffee with $sugarCount spoon of sugar for $name.")
    }
    else if(sugarCount == 0){
        println("Coffee with no spoon of sugar for $name.")
    }
    else{
        println("Coffee with $sugarCount spoons of sugar for $name.")
    }
}
