package com.wx.lib_base.network

import java.io.IOException

sealed class NetResponse<out T : Any, out U : Any> {

    data class Success<T : Any>(val body: T) : NetResponse<T, Nothing>()

    data class ApiError<U : Any>(val body: U, val code: Int) : NetResponse<Nothing, U>()

    data class NetError(val error: IOException) : NetResponse<Nothing, Nothing>()

    data class UnknownError(val error: Throwable?) : NetResponse<Nothing, Nothing>()
}