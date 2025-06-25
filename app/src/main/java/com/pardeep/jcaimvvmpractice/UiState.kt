package com.pardeep.jcaimvvmpractice

sealed class UiState<out T> {

    data class onSuccess<T>(val data: T) : UiState<T>()

    data class onError(val err: String) : UiState<Nothing>()

    object onLoading : UiState<Nothing>()
}