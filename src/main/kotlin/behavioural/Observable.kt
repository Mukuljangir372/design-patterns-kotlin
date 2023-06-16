package behavioural

/**
 * Observable pattern used for observe the changes of state using observer.
 */

fun main() {
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
private interface Observable {
    fun addObserver(observer: Observer)
    fun removeObserver(observer: Observer)
    fun notifyAllObservers()
}

// Observer is one who gets changes of state
private interface Observer {
    fun onChange(value: Int)
}

private interface Station {
    fun setTemp(temp: Int)
}

private class WeatherStation : Station, Observable {
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

private class StationMaster : Observer {
    override fun onChange(value: Int) {
        println("onChange - $value")
    }
}
