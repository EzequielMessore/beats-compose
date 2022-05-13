package br.com.messore.tech.beats.remote.exceptions

sealed class HttpException(
    message: String? = null,
    cause: Throwable? = null
) : Throwable(message, cause)

class UnexpectedException(message: String?) : HttpException()
