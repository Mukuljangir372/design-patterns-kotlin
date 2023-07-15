package structural

/**
 * Flyweight is a structural pattern which is used to minimise the cost
 * of object creation by applying factory design.
 */

fun main() {
    val shape = ShapeFactory().create(1)
}

private interface Shape
private class Rectangle : Shape
private class Circle : Shape

private class ShapeFactory {
    private val cache = hashMapOf<Int, Shape>()
    fun create(size: Int): Shape {
        val cachedShape = cache[size]
        if (cachedShape != null) return cachedShape

        val shape = if (size == 1) Rectangle()
        else Circle()

        cache[size] = shape
        return shape
    }
}