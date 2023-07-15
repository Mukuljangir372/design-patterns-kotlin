package structural

import creational.Amazon

/**
 * Facade pattern is a structural pattern which simplify the complex logic
 * by merging them into one or more api.
 */

fun main() {

}

private interface Product {
    fun sell()
}

private class Google : Product {
    override fun sell() {

    }
}

private class Amazon : Product {
    override fun sell() {

    }
}

private class Facade(private val google: Google, private val amazon: Amazon) {
    fun sell() {
        google.sell()
        google.sell()
    }
}

