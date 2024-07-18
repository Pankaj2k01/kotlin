//Day 2: Functions and OOP Basics
//Task 5: Write functions to add, delete, and edit transactions in a TransactionList class.

/*data class Transaction(val amount: Double, val date: String, val category: String)

class TransactionList {
    private val transactions: MutableList<Transaction> = mutableListOf()

    fun addTransaction(transaction: Transaction) {
        transactions.add(transaction)
    }

    fun deleteTransaction(transaction: Transaction) {
        transactions.remove(transaction)
    }

    fun editTransaction(oldTransaction: Transaction, newTransaction: Transaction) {
        val index = transactions.indexOf(oldTransaction)
        if (index != -1) {
            transactions[index] = newTransaction
        }
    }

    fun getTransactions(): List<Transaction> {
        return transactions
    }
}

fun main() {
    val transactionList = TransactionList()
    val transaction1 = Transaction(10.5, "2022-01-01", "Food")
    val transaction2 = Transaction(20.0, "2022-01-02", "Utilities")

    transactionList.addTransaction(transaction1)
    transactionList.addTransaction(transaction2)

    println("Transactions: ${transactionList.getTransactions()}")

    transactionList.deleteTransaction(transaction1)

    println("Transactions after deletion: ${transactionList.getTransactions()}")

    val transaction3 = Transaction(30.0, "2022-01-03", "Entertainment")
    transactionList.editTransaction(transaction2, transaction3)

    println("Transactions after edit: ${transactionList.getTransactions()}")
}

//Task 6: Develop a simple User class with methods to login and display a summary of expenses.

class TransactionList {
    private val transactions: MutableList<Transaction> = mutableListOf()

    fun addTransaction(transaction: Transaction) {
        transactions.add(transaction)
    }

    fun deleteTransaction(transaction: Transaction) {
        transactions.remove(transaction)
    }

    fun editTransaction(oldTransaction: Transaction, newTransaction: Transaction) {
        val index = transactions.indexOf(oldTransaction)
        if (index!= -1) {
            transactions[index] = newTransaction
        }
    }

    fun getTransactions(): List<Transaction> {
        return transactions
    }
}

class User(val username: String, val password: String, val transactionList: TransactionList) {
    fun login(username: String, password: String): Boolean {
        return this.username == username && this.password == password
    }

    fun displaySummaryOfExpenses() {
        val totalExpenses = transactionList.getTransactions().filter { it.category!= "Income" }.sumOf { it.amount }
        println("Summary of expenses for $username: $totalExpenses dollars")
    }
}

fun main() {
    val transactionList = TransactionList()
    val user = User("john", "password", transactionList)

    if (user.login("john", "password")) {
        println("Login successful!")
        user.displaySummaryOfExpenses()
    } else {
        println("Invalid username or password.")
    }
}

//Task 7: Use lambdas and higher-order functions to filter and sort transactions by date or amount.

fun main() {
    val transactions = listOf(
        Transaction(10.5, "2022-01-01", "Food"),
        Transaction(20.0, "2022-01-02", "Utilities"),
        Transaction(30.0, "2022-01-03", "Entertainment"),
        Transaction(40.0, "2022-01-04", "Food"),
        Transaction(50.0, "2022-01-05", "Utilities")
    )

    // Filter transactions by category
    val foodTransactions = transactions.filter { it.category == "Food" }
    println("Food transactions: $foodTransactions")

    // Sort transactions by date
    val sortedTransactionsByDate = transactions.sortedBy { it.date }
    println("Transactions sorted by date: $sortedTransactionsByDate")

    // Sort transactions by amount
    val sortedTransactionsByAmount = transactions.sortedBy { it.amount }
    println("Transactions sorted by amount: $sortedTransactionsByAmount")
}*/

//Task 8: Implement inheritance by creating specific transaction classes like Income and Expense that inherit from Transaction.

open class Transaction(val amount: Double, val date: String, val category: String)

class Income(amount: Double, date: String, category: String) : Transaction(amount, date, category) {
    override fun toString(): String {
        return "Income of $amount dollars on $date in category $category"
    }
}

class Expense(amount: Double, date: String, category: String) : Transaction(amount, date, category) {
    override fun toString(): String {
        return "Expense of $amount dollars on $date in category $category"
    }
}

fun main() {
    val income = Income(100.0, "2022-01-01", "Salary")
    val expense = Expense(50.0, "2022-01-02", "Food")

    println("Income: $income")
    println("Expense: $expense")
}