package behavioural

/**
 * State is one of simplest behavioural design pattern in kotlin
 * which is used for presenting a state.
 */

fun main() {

}

private sealed interface LoginState {
    object Active : LoginState
    object InActive : LoginState
    object Idle : LoginState
}

private class AuthPresenter {
    private var state: LoginState = LoginState.Idle

    fun login() {
        state = LoginState.Active
    }

    fun logout() {
        state = LoginState.InActive
    }
}

