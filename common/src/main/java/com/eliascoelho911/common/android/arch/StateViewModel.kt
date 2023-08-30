package com.eliascoelho911.common.android.arch

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

abstract class StateViewModel<STATE>(initialState: STATE) : ViewModel() {
    private val _state: MutableStateFlow<STATE> = MutableStateFlow(initialState)
    val state: StateFlow<STATE> = _state

    fun setState(state: (currentState: STATE) -> STATE) {
        _state.value = state(_state.value)
    }
}