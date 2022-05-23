package br.com.messore.tech.beats.register.view.model

sealed interface RegisterActions {
    object Registered : RegisterActions
    data class Failure(val message: String?) : RegisterActions
}
