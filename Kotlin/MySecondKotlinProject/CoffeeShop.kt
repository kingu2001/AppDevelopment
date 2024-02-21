fun main() {
    println("Welcome! What can I do for you?")
    val c = Customer("Matthew")
    c.order()
    println("\n Sure. What would you like to order?")

    //Prints the menu and separate them with a new line. 
    val menu = Coffee().coffeeList.joinToString("\n")
    println(menu)
    var choice = readLine()!!.toInt()
    when(choice){
        1 -> {
            val cap = Coffee().coffeeList.get(0).removePrefix("1.")
            println("You have chosen ${cap}. Which size do you want?")
            println("1. Small")
            println("2. Medium")
            println("3. Large")
            val capSize = readLine()!!.toInt()
            when(capSize){
                1 -> {
                    println("Here is your ${CupSize.Small} ${cap}.")
                }
                2 -> {
                    println("Here is your ${CupSize.Medium} ${cap}.")
                }
                3 -> {
                    println("Here is your ${CupSize.Large} ${cap}.")
                }
                else -> {
                    println("Invalid size.")
                }
            }


        }
        2 -> {
            val lat = Coffee().coffeeList.get(1).removePrefix("2.")
            println("You have chosen ${lat}. Which size do you want?")
            println("1. Small")
            println("2. Medium")
            println("3. Large")
            val latSize = readLine()!!.toInt()
            when(latSize){
                1 -> {
                    println("Here is your ${CupSize.Small} ${lat}.")
                }
                2 -> {
                    println("Here is your ${CupSize.Medium} ${lat}.")
                }
                3 -> {
                    println("Here is your ${CupSize.Large} ${lat}.")
                }
                else -> {
                    println("Invalid size.")
                }
            }
        }
        3 -> {
            val blk = Coffee().coffeeList.get(3).removePrefix("3.")
            println("You have chosen ${blk}. Which size do you want?")
            println("1. Small")
            println("2. Medium")
            println("3. Large")
            val blkSize = readLine()!!.toInt()
            when(blkSize){
                1 -> {
                    println("Here is your ${CupSize.Small} ${blk}.")
                }
                2 -> {
                    println("Here is your ${CupSize.Medium} ${blk}.")
                }
                3 -> {
                    println("Here is your ${CupSize.Large} ${blk}.")
                }
                else -> {
                    println("Invalid size.")
                }
            }
        }
        else -> {
            println("Invalid input.")
        }
    }


}

//Customer 
class Customer(var name : String)
{
    fun order() = println("Hi! My name is ${name}. I would like to order.")
}

//Price based on the size of the cup
enum class CupSize(){
    Small,
    Medium,
    Large
}

class Coffee()
{
    val coffeeList : List<String> = listOf(
        "1. Capucchino",
        "2. Latte",
        "3. Black"
    )
}