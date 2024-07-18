//Day 2: Functions and OOP Basics
//Task 5: Design a EventManager class with methods to add and remove events

/*data class Event(val name: String, val date: String, val attendeeCount: Int)

class EventManager {
    private val events: MutableList<Event> = mutableListOf()
    fun addEvent(event: Event) {
        events.add(event)
    }
    fun removeEvent(event: Event) {
        events.remove(event)
    }
    fun getEvents(): List<Event> {
        return events
    }
}

fun main() {
    val eventManager = EventManager()
    val event1 = Event("Conference", "2022-01-01", 100)
    val event2 = Event("Seminar", "2022-01-02", 50)
    eventManager.addEvent(event1)
    eventManager.addEvent(event2)
    println("Events: ${eventManager.getEvents()}")
    eventManager.removeEvent(event1)
    println("Events after removal: ${eventManager.getEvents()}")
}

//Task 6: Create a Display interface with a method to show event details and implement it in the EventManager.

interface Display {
    fun showEventDetails(event: Event)
}

class EventManager : Display {
    private val events: MutableList<Event> = mutableListOf()

    fun addEvent(event: Event) {
        events.add(event)
    }

    fun removeEvent(event: Event) {
        events.remove(event)
    }

    fun getEvents(): List<Event> {
        return events
    }

    override fun showEventDetails(event: Event) {
        println("Event: ${event.name} on ${event.date} with ${event.attendeeCount} attendees.")
    }
}

fun main() {
    val eventManager = EventManager()
    val event = Event("Conference", "2022-01-01", 100)

    eventManager.addEvent(event)

    eventManager.showEventDetails(event)
}

//Task 7: Utilize higher-order functions to implement a simple notification system for event updates.

class EventManager {
    private val events: MutableList<Event> = mutableListOf()
    private val notificationListeners: MutableList<(Event) -> Unit> = mutableListOf()

    fun addEvent(event: Event) {
        events.add(event)
        notifyListeners(event)
    }

    fun removeEvent(event: Event) {
        events.remove(event)
        notifyListeners(event)
    }

    fun getEvents(): List<Event> {
        return events
    }

    fun addNotificationListener(listener: (Event) -> Unit) {
        notificationListeners.add(listener)
    }

    private fun notifyListeners(event: Event) {
        notificationListeners.forEach { it(event) }
    }
}

fun main() {
    val eventManager = EventManager()

    eventManager.addNotificationListener { event ->
        println("Event updated: ${event.name} on ${event.date} with ${event.attendeeCount} attendees.")
    }

    val event = Event("Conference", "2022-01-01", 100)
    eventManager.addEvent(event)
}*/

//Task 8: Construct subclass SpecialEvent with additional features like VIP lists and premium services.

open class Event(open val name: String, open val date: String, open val attendeeCount: Int) {
    override fun toString(): String {
        return "Event: $name on $date with $attendeeCount attendees"
    }
}

class SpecialEvent(name: String, date: String, attendeeCount: Int, val vipList: List<String>, val premiumServices: List<String>) : Event(name, date, attendeeCount) {
    override fun toString(): String {
        return "Special Event: $name on $date with $attendeeCount attendees, VIP list: $vipList, Premium services: $premiumServices"
    }
}

fun main() {
    val specialEvent = SpecialEvent("Conference", "2022-01-01", 100, listOf("John", "Jane"), listOf("Catering", "Parking"))
    println(specialEvent)
}