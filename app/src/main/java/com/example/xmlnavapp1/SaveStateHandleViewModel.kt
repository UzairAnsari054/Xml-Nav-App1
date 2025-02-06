package com.example.xmlnavapp1

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class SaveStateHandleViewModel(
    private val stateHandle: SavedStateHandle
) : ViewModel() {

    private var _counter = MutableLiveData(0)
    val counter: LiveData<Int> = _counter


    fun updateCounter() {
        val counter = _counter.value ?: 0
        _counter.value = counter + 1
    }


    companion object {
        private const val NAME = "name"
        private const val AGE = "age"
    }

    var name: String?
        get() = stateHandle[NAME]
        set(value) {
            stateHandle[NAME] = value
        }

    var age: Int?
        get() = stateHandle[AGE]
        set(value) {
            stateHandle[AGE] = value
        }
}