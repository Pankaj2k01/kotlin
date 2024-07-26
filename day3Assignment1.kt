//Day 3: Interfaces, Encapsulation, and Advanced Concepts / Collections and Generics
//Task 9: Define an Exportable interface with a method to export transaction data to CSV.

/*interface Exportable {
    fun exportToCSV(): String
}

// Update Transaction class to implement Exportable interface
data class Transaction(val amount: Double, val date: String, val category: String) : Exportable {
    override fun exportToCSV(): String {
        return "$amount,$date,$category"
    }
}

fun main() {
    val transaction = Transaction(10.5, "2022-01-01", "Food")
    println(transaction.exportToCSV()) // Output: 10.5,2022-01-01,Food
}

//Task 10: Apply encapsulation to Transaction properties using getters and setters ensuring sensitive data is protected.

class Transaction(private var _amount: Double, private var _date: String, private var _category: String) {
    val amount: Double
        get() = _amount

    val date: String
        get() = _date

    val category: String
        get() = _category

    fun updateAmount(newAmount: Double) {
        if (newAmount > 0) {
            _amount = newAmount
        }
    }

    fun updateDate(newDate: String) {
        _date = newDate
    }

    fun updateCategory(newCategory: String) {
        _category = newCategory
    }
}

fun main() {
    val transaction = Transaction(10.5, "2022-01-01", "Food")
    println(transaction.amount) // Output: 10.5

    transaction.updateAmount(20.0)
    println(transaction.amount) // Output: 20.0
}

//Task 11: Create generic functions to handle different types of collections (List, Set, Map) of transactions.

data class Transaction(val amount: Double, val date: String, val category: String)

fun printTransactions(transactions: Iterable<Transaction>) {
    for (transaction in transactions) {
        println("Amount: ${transaction.amount}, Date: ${transaction.date}, Category: ${transaction.category}")
    }
}

fun main() {
    val transactionList = listOf(Transaction(10.5, "2022-01-01", "Food"), Transaction(20.0, "2022-01-02", "Utilities"))
    val transactionSet = setOf(Transaction(10.5, "2022-01-01", "Food"), Transaction(20.0, "2022-01-02", "Utilities"))
    val transactionMap = mapOf("1" to Transaction(10.5, "2022-01-01", "Food"), "2" to Transaction(20.0, "2022-01-02", "Utilities"))

    printTransactions(transactionList)
    printTransactions(transactionSet)
    printTransactions(transactionMap.values)
}*/

//Task 12: Utilize Kotlin's collection libraries to manage a collection of User objects, enabling the addition and removal of users.

import java.util.Scanner;
class User(val username: String, val password: String)

class UserManager {
    private val users: MutableMap<String, User> = mutableMapOf()

    fun addUser(user: User) {
        users[user.username] = user
    }

    fun removeUser(username: String) {
        users.remove(username)
    }

    fun getUser(username: String): User? {
        return users[username]
    }

    fun getAllUsers(): List<User> {
        return users.values.toList()
    }
}

fun main() {
    val userManager = UserManager()
    val scanner = Scanner(System.`in`)

    while (true) {
        println("1. Add user")
        println("2. Remove user")
        println("3. Get user")
        println("4. Get all users")
        println("5. Exit")
        print("Choose an option: ")

        when (scanner.nextInt()) {
            1 -> {
                print("Enter username: ")
                val username = scanner.next()
                print("Enter password: ")
                val password = scanner.next()
                userManager.addUser(User(username, password))
                println("User added successfully!")
            }
            2 -> {
                print("Enter username to remove: ")
                val username = scanner.next()
                userManager.removeUser(username)
                println("User removed successfully!")
            }
            3 -> {
                print("Enter username to get: ")
                val username = scanner.next()
                val user = userManager.getUser(username)
                if (user != null) {
                    println("User found: ${user.username} - ${user.password}")
                } else {
                    println("User not found")
                }
            }
            4 -> {
                val allUsers = userManager.getAllUsers()
                if (allUsers.isNotEmpty()) {
                    println("All users:")
                    allUsers.forEach { println("${it.username} - ${it.password}") }
                } else {
                    println("No users found")
                }
            }
            5 -> {
                println("Exiting...")
                return
            }
            else -> {
                println("Invalid option. Please choose a valid option.")
            }
        }
    }
}
