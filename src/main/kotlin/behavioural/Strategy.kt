package behavioural

/**
 * In strategy pattern, login and process are interchangeable at runtime.
 * In simple words, execution can be changed at runtime.
 */
fun main() {
    val context = PaymentContext()

    val paytmPaymentStrategy = PaytmPaymentStrategy()
    val googlePaymentStrategy = GooglePaymentStrategy()

    context.setStrategy(paytmPaymentStrategy)
    context.pay(1)

    context.setStrategy(googlePaymentStrategy)
    context.pay(2)
}

private interface PaymentStrategy {
    fun pay(orderId: Int)
}

private class PaytmPaymentStrategy : PaymentStrategy {
    override fun pay(orderId: Int) {

    }
}

private class GooglePaymentStrategy : PaymentStrategy {
    override fun pay(orderId: Int) {

    }
}

private class PaymentContext {
    private lateinit var strategy: PaymentStrategy
    fun setStrategy(strategy: PaymentStrategy) {
        this.strategy = strategy
    }

    fun pay(orderId: Int) {
        strategy.pay(orderId + 10)
    }
}


