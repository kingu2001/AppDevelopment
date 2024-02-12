class Calculator{
    fun addition(x : Int, y : Int): Int
    {
        return x + y
    }

    //alt. way of writing a function -> fun addition(x : Int, y : Int) = x + y

    fun subtraction(x : Int, y : Int): Int
    {
        return x - y
    }

    fun multiplication(x : Int, y : Int): Int
    {
        return x * y 
    }

    fun division(x : Int, y : Int): Double
    {
        return if (y != 0) {
            x.toDouble() / y.toDouble()
        }
        else
        {
            throw IllegalArgumentException("Division by zero is not allowed")
        }
    }
}

fun main() {
    val calculator = Calculator()
    println("Welcome. What would you like to do?")
    println("1. Addition")
    println("2. Subtraction")
    println("3. Multiplication")
    println("4. Division")

    var choice = readLine()!!.toInt()
    when(choice)
    {
        1 -> 
        {
            println("Enter the first number: ")
            var x = readLine()!!.toInt()
            println("Enter the second number: ")
            var y = readLine()!!.toInt()
            print("The sum is ${calculator.addition(x, y)}")
        }
        2 -> 
        {
            println("Enter the first number: ")
            var x = readLine()!!.toInt()
            println("Enter the second number: ")
            var y = readLine()!!.toInt()
            print("The sum is ${calculator.subtraction(x, y)}")
        }
        3 -> 
        {
            println("Enter the first number: ")
            var x = readLine()!!.toInt()
            println("Enter the second number: ")
            var y = readLine()!!.toInt()
            print("The sum is ${calculator.multiplication(x, y)}")
        }
        4 -> 
        {
            println("Enter the first number: ")
            var x = readLine()!!.toInt()
            println("Enter the second number: ")
            var y = readLine()!!.toInt()
            print("The sum is ${calculator.division(x, y)}")
        }
        5 -> println("Exiting...")
        else -> println("Invalid input.")
    }
    
}