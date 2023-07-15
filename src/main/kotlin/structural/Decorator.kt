package structural

/**
 * Decorator pattern is a structural pattern which is used to
 * extend the structure.
 */

fun main() {
    val coffee = ExpressCoffee()
    val milkCoffee = Milk(coffee)
    milkCoffee.getCost()
}

interface Coffee {
    fun getCost(): Int
}

class NormalCoffee : Coffee {
    override fun getCost(): Int {
        return 1
    }
}

class ExpressCoffee : Coffee {
    override fun getCost(): Int {
        return 2
    }
}

class Milk(private val coffee: Coffee) : Coffee {
    override fun getCost(): Int {
        return 1 + coffee.getCost()
    }
}

