package br.com.messore.tech.beats.headset.detail

import android.os.Bundle
import androidx.lifecycle.viewModelScope
import br.com.messore.tech.beats.domain.model.Headset
import br.com.messore.tech.beats.domain.usecase.GetHeadsetUseCase
import br.com.messore.tech.beats.view.model.BaseViewModel
import br.com.messore.tech.beats.view.model.runCatching
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HeadsetDetailViewModel(
    args: Bundle,
    private val getHeadsetUseCase: GetHeadsetUseCase,
) : BaseViewModel<HeadsetDetailState, HeadsetDetailAction>(HeadsetDetailState()) {

    private val headsetId: Int = checkNotNull(args.getInt("headsetId"))

    init {
        getHeadset()
    }

    private fun getHeadset() = viewModelScope.launch {
        setState { copy(loading = true) }
        runCatching(
            dispatcher = Dispatchers.Default,
            execute = {
                getHeadsetUseCase(headsetId)
            },
            onSuccess = {
                setState { copy(loading = false, headset = it) }
            },
            onFailure = {
                setState { copy(loading = false) }
            }
        )
    }
}

data class HeadsetDetailState(
    val loading: Boolean = false,
    val headset: Headset? = null
)

sealed interface HeadsetDetailAction