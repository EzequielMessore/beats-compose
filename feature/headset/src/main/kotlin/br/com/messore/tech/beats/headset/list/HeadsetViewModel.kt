package br.com.messore.tech.beats.headset.list

import androidx.lifecycle.viewModelScope
import br.com.messore.tech.beats.domain.model.Headset
import br.com.messore.tech.beats.domain.usecase.ListHeadsetUseCase
import br.com.messore.tech.beats.view.model.BaseViewModel
import br.com.messore.tech.beats.view.model.runCatching
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HeadsetViewModel(
    private val listHeadsetUseCase: ListHeadsetUseCase,
) : BaseViewModel<HeadsetState, HeadsetAction>(HeadsetState()) {

    init {
        getHeadsets()
    }

    private fun getHeadsets() = viewModelScope.launch {
        setState { copy(loading = true) }
        runCatching(
            dispatcher = Dispatchers.Default,
            execute = {
                listHeadsetUseCase()
            },
            onSuccess = {
                setState { copy(loading = false, headsets = it) }
            },
            onFailure = {
                setState { copy(loading = false) }
            }
        )
    }
}


data class HeadsetState(
    val loading: Boolean = false,
    val headsets: List<Headset> = emptyList()
)

sealed interface HeadsetAction
