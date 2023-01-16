package com.ghao.lib.core.repository

sealed class Result<out T> {
    object Loading: Result<Nothing>()
    data class Success<T>(val content: T) : Result<T>()
    data class Error(val e: Throwable) : Result<Nothing>()
}
