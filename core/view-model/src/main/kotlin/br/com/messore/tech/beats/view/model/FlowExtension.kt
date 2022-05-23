package br.com.messore.tech.beats.view.model

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

fun <T> Flow<T>.observe(owner: LifecycleOwner, observe: (T) -> Unit) {
    owner.lifecycleScope.launch {
        owner.repeatOnLifecycle(Lifecycle.State.STARTED) {
            this@observe.collect(observe)
        }
    }
}

suspend fun <T, R> T.runCatching(
    dispatcher: CoroutineDispatcher,
    execute: suspend () -> R,
    onSuccess: R.() -> Unit = {},
    onFailure: Throwable.() -> Unit = {}
) {
    runCatching {
        withContext(dispatcher) { execute() }
    }.onSuccess(onSuccess).onFailure(onFailure)
}
