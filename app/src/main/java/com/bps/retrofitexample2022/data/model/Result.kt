package com.bps.retrofitexample2022.data.model

sealed class Result<out R>() {
    data class Success<out T>(val data: T): Result<T>()
    data class Error(val exception: Exception): Result<Nothing>()
}
