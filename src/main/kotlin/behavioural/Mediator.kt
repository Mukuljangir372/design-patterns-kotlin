package behavioural

/**
 * Mediator is a behavioural pattern used to make communication between
 * multiple objects.
 */
fun main() {
    val message = ""
    val mediator = ChatMediator()
    mediator.sendMessage(message)
}

private interface Mediator

private class ChatMediator : Mediator {
    fun sendMessage(msg: String) {

    }
}

