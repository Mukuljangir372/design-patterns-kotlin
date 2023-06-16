package behavioural

/**
 * Observable pattern used for observe the changes of state using observer.
 */

fun main(args: Array<String>) {
    val station = WeatherStation()

    val observer = StationMaster()
    station.addObserver(observer)

    station.setTemp(1)
    station.setTemp(2)
    station.setTemp(3)

    station.removeObserver(observer)

    station.setTemp(4)
}

// Observable is responsible for adding, removing, notify observers.
interface Observable {
    fun addObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyAllObservers()
}

// Observer is one who gets changes of state
interface Observer {
    fun onChange(value: Int)
}

interface Station {
    fun setTemp(temp: Int)
}

class WeatherStation : Station, Observable {
    private val observers = mutableListOf<Observer>()

    private var temp: Int = 0
    override fun setTemp(temp: Int) {
        this.temp = temp
        notifyAllObservers()
    }

    override fun addObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun removeObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyAllObservers() {
        observers.forEach { it.onChange(temp) }
    }
}

class StationMaster : Observer {
    override fun onChange(value: Int) {
        println("onChange - $value")
    }
}
