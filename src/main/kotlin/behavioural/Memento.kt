package behavioural

/**
 * Memento is a part of behavioural pattern which is used to save and restore state.
 */

fun main() {
    val state = State(id = "", name = "")
    val memento = Memento()

    // save the state
    memento.save(state)
    // restore the state
    memento.restore(state.id)
}

private data class State(val id: String, val name: String)
private interface Store {
    fun save(save: State)
    fun restore(id: String): State?
}

private class Memento : Store {
    private val states = hashMapOf<String, State>()
    override fun save(save: State) {
        states[save.id] = save
    }

    override fun restore(id: String): State? {
        return states[id]
    }
}
