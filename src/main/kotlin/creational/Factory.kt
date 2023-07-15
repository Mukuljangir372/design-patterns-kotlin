package creational

/**
 * Factory pattern is a part of creational pattern which is used to
 * create object without specifying the exact class that will be created.
 */

fun main() {
    val company = CompanyFactory().create(11)
}

interface Company
class Google : Company
class Amazon : Company

class CompanyFactory {
    fun create(rating: Int): Company {
        return if (rating > 10) Google()
        else Amazon()
    }
}