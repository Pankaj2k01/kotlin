//Development Scenario 2: Event Management System
 
//Day 1: Introduction and Setup
//Task 1: Set up the Kotlin development environment and write a simple Kotlin script to validate the setup.

/*fun main() {
    println("Event Management System is set up!")
}

//Task 2: Experiment with Kotlin's string templates to create dynamic welcome messages.

fun createWelcomeMessage(name: String): String {
    return "Welcome, $name! to the Event Management System."
}
fun main() {
    val name = "John"
    println(createWelcomeMessage(name))
}*/

//Task 3: Define data types to represent event details such as name, date, and attendee count.

data class Event(val name: String, val date: String, val attendeeCount: Int)

//Task 4: Implement a basic user input flow to create new events using if and when statements.

fun createEvent(): Event {
    print("Enter event name: ")
    val name = readLine()!!
    print("Enter event date (yyyy-mm-dd): ")
    val date = readLine()!!
    print("Enter attendee count: ")
    val attendeeCount = readLine()!!.toInt()
    return Event(name, date, attendeeCount)
}

fun main() {
    val event = createEvent()
    println("Event created: ${event.name} on ${event.date} with ${event.attendeeCount} attendees.")
}