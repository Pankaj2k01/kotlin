// Task 9: Develop a Schedule class that uses interfaces to ensure that all event types can be scheduled and rescheduled.
/*interface Schedulable {
    fun schedule(date: String)
    fun reschedule(date: String)
}

class Schedule {
    private val events: MutableList<Schedulable> = mutableListOf()

    fun addEvent(event: Schedulable) {
        events.add(event)
    }

    fun scheduleEvent(event: Schedulable, date: String) {
        event.schedule(date)
    }

    fun rescheduleEvent(event: Schedulable, date: String) {
        event.reschedule(date)
    }
}

class Event(val name: String) : Schedulable {
    private var date: String = ""

    override fun schedule(date: String) {
        this.date = date
        println("Event $name scheduled for $date")
    }

    override fun reschedule(date: String) {
        this.date = date
        println("Event $name rescheduled for $date")
    }
}

fun main() {
    val schedule = Schedule()
    print("Enter event name: ")
    val eventName = readLine()!!
    val event = Event(eventName)

    schedule.addEvent(event)

    print("Enter initial date: ")
    val initialDate = readLine()!!
    schedule.scheduleEvent(event, initialDate)

    print("Enter new date: ")
    val newDate = readLine()!!
    schedule.rescheduleEvent(event, newDate)
}

// Task 10: Secure the event data with proper encapsulation and visibility modifiers.
class SecureEvent(private val name: String, private val date: String, private val attendeeCount: Int) {
    fun getName(): String {
        return name
    }

    fun getDate(): String {
        return date
    }

    fun getAttendeeCount(): Int {
        return attendeeCount
    }
}

fun main() {
    print("Enter event name: ")
    val eventName = readLine()!!
    print("Enter event date: ")
    val eventDate = readLine()!!
    print("Enter attendee count: ")
    val attendeeCount = readLine()!!.toInt()

    val secureEvent = SecureEvent(eventName, eventDate, attendeeCount)
    println("Event: ${secureEvent.getName()} on ${secureEvent.getDate()} with ${secureEvent.getAttendeeCount()} attendees.")
}

// Task 11: Manage a collection of events allowing filtering by date or type using Kotlin's powerful collection operations.
data class Event(val name: String, val date: String, val attendeeCount: Int)

class EventManager {
    private val events: MutableList<Event> = mutableListOf()

    fun addEvent(event: Event) {
        events.add(event)
    }

    fun getEventsByDate(date: String): List<Event> {
        return events.filter { it.date == date }
    }

    fun getEventsByType(type: String): List<Event> {
        return events.filter { it.name.startsWith(type) }
    }
}

fun main() {
    val eventManager = EventManager()

    while (true) {
        print("Enter event name (or 'quit' to stop): ")
        val eventName = readLine()!!
        if (eventName.lowercase() == "quit") break
        print("Enter event date: ")
        val eventDate = readLine()!!
        print("Enter attendee count: ")
        val attendeeCount = readLine()!!.toInt()

        val event = Event(eventName, eventDate, attendeeCount)
        eventManager.addEvent(event)
    }

    print("Enter date to filter by: ")
    val date = readLine()!!
    println("Events on $date: ${eventManager.getEventsByDate(date)}")

    print("Enter type to filter by: ")
    val type = readLine()!!
    println("Events of type $type: ${eventManager.getEventsByType(type)}")
}*/

// Task 12: Use generics to create a flexible DataManager class capable of handling different data types, including attendees and events.
data class Event(val name: String, val date: String, val attendeeCount: Int)
data class Attendee(val name: String, val email: String)

class DataManager<T> {
    private val data: MutableList<T> = mutableListOf()

    fun addData(item: T) {
        data.add(item)
    }

    fun getData(): List<T> {
        return data
    }
}

fun main() {
    val eventDataManager = DataManager<Event>()
    val attendeeDataManager = DataManager<Attendee>()

    while (true) {
        print("Enter event name (or 'quit' to stop): ")
        val eventName = readLine()!!
        if (eventName.lowercase() == "quit") break
        print("Enter event date: ")
        val eventDate = readLine()!!
        print("Enter attendee count: ")
        val attendeeCount = readLine()!!.toInt()

        val event = Event(eventName, eventDate, attendeeCount)
        eventDataManager.addData(event)
    }

    while (true) {
        print("Enter attendee name (or 'quit' to stop): ")
        val attendeeName = readLine()!!
        if (attendeeName.lowercase() == "quit") break
        print("Enter attendee email: ")
        val attendeeEmail = readLine()!!
        val attendee = Attendee(attendeeName, attendeeEmail)
        attendeeDataManager.addData(attendee)
    }

    println("Events: ${eventDataManager.getData()}")
    println("Attendees: ${attendeeDataManager.getData()}")
}
