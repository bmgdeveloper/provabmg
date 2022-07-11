package com.picpay.desafio.android.base

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

open class BaseViewModel: ViewModel() {

    private val scope = CoroutineScope(Job() + Dispatchers.Main)

    fun <T> coroutineScope(action: suspend () -> T) {
        scope.launch {
                action.invoke()
        }
    }

}