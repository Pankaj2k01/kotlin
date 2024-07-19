class Employee(val id: Int, var name: String, var department: String, var salary: Double) {
    override fun toString(): String {
        return "Employee $id: $name, Department: $department, Salary: $salary"
    }
}

class EmployeeManagementSystem {
    private val employees: MutableList<Employee> = mutableListOf()

    fun addEmployee(employee: Employee) {
        employees.add(employee)
    }

    fun removeEmployee(id: Int) {
        employees.removeIf { it.id == id }
    }

    fun updateEmployee(id: Int, name: String, department: String, salary: Double) {
        employees.find { it.id == id }?.let {
            it.name = name
            it.department = department
            it.salary = salary
        }
    }

    fun getAllEmployees(): List<Employee> {
        return employees
    }

    fun getEmployeeById(id: Int): Employee? {
        return employees.find { it.id == id }
    }
}

fun main() {
    val ems = EmployeeManagementSystem()

    while (true) {
        println("Employee Management System")
        println("1. Add Employee")
        println("2. Delete Employee")
        println("3. Update Employee")
        println("4. Search Employee")
        println("5. Get All Employees")
        println("6. Exit")

        print("Enter your choice: ")
        val choice = readLine()!!.toInt()

        when (choice) {
            1 -> {
                print("Enter employee ID: ")
                val id = readLine()!!.toInt()
                print("Enter employee name: ")
                val name = readLine()!!
                print("Enter employee department: ")
                val department = readLine()!!
                print("Enter employee salary: ")
                val salary = readLine()!!.toDouble()
                ems.addEmployee(Employee(id, name, department, salary))
                println("Employee added successfully!")
            }
            2 -> {
                print("Enter employee ID to delete: ")
                val id = readLine()!!.toInt()
                ems.removeEmployee(id)
                println("Employee deleted successfully!")
            }
            3 -> {
                print("Enter employee ID to update: ")
                val id = readLine()!!.toInt()
                print("Enter new employee name: ")
                val name = readLine()!!
                print("Enter new employee department: ")
                val department = readLine()!!
                print("Enter new employee salary: ")
                val salary = readLine()!!.toDouble()
                ems.updateEmployee(id, name, department, salary)
                println("Employee updated successfully!")
            }
            4 -> {
                print("Enter employee ID to search: ")
                val id = readLine()!!.toInt()
                val employee = ems.getEmployeeById(id)
                if (employee != null) {
                    println("Employee found: $employee")
                } else {
                    println("Employee not found!")
                }
            }
            5 -> {
                println("All Employees:")
                ems.getAllEmployees().forEach { println(it) }
            }
            6 -> {
                println("Exiting the system. Goodbye!")
                return
            }
            else -> {
                println("Invalid choice. Please try again!")
            }
        }
    }
}