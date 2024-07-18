//Development Scenario 1: Personal Finance Tracker
 
//Day 1: Introduction and Setup and Variables and Control Structures
//Task 1: Install Kotlin and configure IntelliJ IDEA. Verify the setup by running a "Hello, World!" program.

/*fun main() {
println("Hello, World!")
}

//Task 2: Explore Kotlin REPL (Read-Eval-Print Loop) to familiarize with Kotlin syntax and basic operations.

val name = "John"
println("Hello, $name!")

val amount = 10.5
println("You have $amount dollars.")

val isExpense = true
if (isExpense) {
   println("This is an expense.")
} else {
   println("This is an income.")
}*/

//Task 3: Create a Transaction class with properties such as amount, date, and category.

data class Transaction(val amount: Double, val date: String, val category: String)

//Task 4: Implement control structures to categorize transactions (e.g., Food, Utilities, Entertainment) using when statements.

fun categorizeTransaction(transaction: Transaction): String {
    return when (transaction.category) {
        "Food" -> "You spent ${transaction.amount} dollars on food."
        "Utilities" -> "You paid ${transaction.amount} dollars for utilities."
        "Entertainment" -> "You spent ${transaction.amount} dollars on entertainment."
        else -> "Unknown category."
    }
}

fun main() {
    val transaction = Transaction(10.5, "2022-01-01", "Food")
    println(categorizeTransaction(transaction))
}