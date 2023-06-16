package behavioural

/**
 * Chain of responsibility pattern is a behavioural pattern used for building
 * a chain of object with a request, each request can be handle immediately or
 * passed to another object.
 */

fun main() {
    val ceoRequestHandler = CEORequestHandler()
    val managerRequestHandler = ManagerRequestHandler()
    val developerRequestHandler = DeveloperRequestHandler()

    ceoRequestHandler.setNextRequest(managerRequestHandler)
    managerRequestHandler.setNextRequest(developerRequestHandler)

    ceoRequestHandler.handleRequest(1)
}

private abstract class Handler {
    private var _nextRequest: Handler? = null
    val nextRequest: Handler? get() = _nextRequest

    fun setNextRequest(request: Handler) {
        _nextRequest = request
    }

    abstract fun handleRequest(amount: Int)
}

private class CEORequestHandler() : Handler() {
    override fun handleRequest(amount: Int) {
        if (amount == 1) {
            println("ceo handled")
        } else {
            nextRequest?.handleRequest(amount)
        }
    }
}

private class ManagerRequestHandler() : Handler() {
    override fun handleRequest(amount: Int) {
        if (amount == 2) {
            println("manager handled")
        } else {
            nextRequest?.handleRequest(amount)
        }
    }
}

private class DeveloperRequestHandler() : Handler() {
    override fun handleRequest(amount: Int) {
        if (amount == 3) {
            println("developer handled")
        } else {
            nextRequest?.handleRequest(amount)
        }
    }
}