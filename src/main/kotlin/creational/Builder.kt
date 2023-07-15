package creational

/**
 * Builder pattern is a part of creational pattern which is used to
 * create object having complex structure.
 */
fun main() {
    val dialog = Dialog.Builder().build()
}

class Dialog private constructor(
    private val title: String,
    private val message: String
) {
    class Builder constructor() {
        private var title: String = ""
        private var message: String = ""

        fun setTitle(title: String) {
            this.title = title
        }

        fun setMessage(message: String) {
            this.message = message
        }

        fun build(): Dialog {
            return Dialog(
                title = title,
                message = message
            )
        }
    }
}