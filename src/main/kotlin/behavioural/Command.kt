package behavioural

/**
 * Command design pattern is a part of behavioural pattern which is used
 * for pushing the action that can be execute at any time on demand using command executor.
 */

fun main() {
    val host = PaymentHost()
    val makePaymentCommand = MakePaymentCommand(host, 1)
    val revertPaymentCommand = RevertPaymentCommand(host, 1)
    val executor = PaymentCommandExecutor()

    executor.execute(makePaymentCommand)
    host.printPayments()

    executor.execute(revertPaymentCommand)
    host.printPayments()

    executor.execute(makePaymentCommand)
    host.printPayments()
}

private interface Command {
    fun execute()
}

private class MakePaymentCommand(
    private val host: PaymentHost, private val order: Int
) : Command {
    override fun execute() {
        host.make(order)
    }
}

private class RevertPaymentCommand(
    private val host: PaymentHost, private val order: Int
) : Command {
    override fun execute() {
        host.revert(order)
    }
}

private class PaymentHost {
    private val payments = mutableListOf<Int>()

    fun make(order: Int) {
        payments.add(order)
    }

    fun revert(order: Int) {
        payments.remove(order)
    }

    fun printPayments() {
        if (payments.isEmpty()) {
            println("no payment found")
        } else {
            payments.forEach { println("order id - $it") }
        }
    }
}

private class PaymentCommandExecutor {
    private val commands = mutableListOf<Command>()

    fun execute(command: Command) {
        commands.add(command)
        command.execute()
    }
}