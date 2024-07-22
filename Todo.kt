data class Todo(var id: Int, var title: String, var description: String? = null, var isDone: Boolean = false)

object TodoManager {
    private val todos = mutableListOf<Todo>()
    private var idCounter = 1

    fun addTodo(title: String, description: String? = null) {
        val todo = Todo(idCounter, title, description)
        todos.add(todo)
        idCounter++
    }

    fun getTodos(): List<Todo> {
        return todos
    }

    fun updateTodo(id: Int, title: String? = null, description: String? = null, isDone: Boolean? = null) {
        val todo = todos.find { it.id == id }
        if (todo != null) {
            title?.let { todo.title = it }
            description?.let { todo.description = it }
            isDone?.let { todo.isDone = it }
        }
    }

    fun deleteTodo(id: Int) {
        todos.removeIf { it.id == id }
    }

    fun displayTodos() {
        for (todo in todos) {
            println("ID: ${todo.id}, Title: ${todo.title}, Description: ${todo.description}, Is Done: ${todo.isDone}")
        }
    }
}

fun main() {
    while (true) {
        println("1. Add Todo")
        println("2. Display Todos")
        println("3. Update Todo")
        println("4. Delete Todo")
        println("5. Exit")
        print("Choose an option: ")
        val option = readLine()!!.trim().toInt()

        when (option) {
            1 -> {
                print("Enter title: ")
                val title = readLine()!!.trim()
                print("Enter description (optional): ")
                val description = readLine()!!.trim().ifBlank { null }
                TodoManager.addTodo(title, description)
            }
            2 -> TodoManager.displayTodos()
            3 -> {
                print("Enter todo ID: ")
                val id = readLine()!!.trim().toInt()
                print("Enter new title (optional): ")
                val title = readLine()!!.trim().ifBlank { null }
                print("Enter new description (optional): ")
                val description = readLine()!!.trim().ifBlank { null }
                print("Is done? (true/false): ")
                val isDone = readLine()!!.trim().toBoolean()
                TodoManager.updateTodo(id, title, description, isDone)
            }
            4 -> {
                print("Enter todo ID to delete: ")
                val id = readLine()!!.trim().toInt()
                TodoManager.deleteTodo(id)
                println("Todo deleted successfully!")
            }
            5 -> break
            else -> println("Invalid option")
        }
    }
}