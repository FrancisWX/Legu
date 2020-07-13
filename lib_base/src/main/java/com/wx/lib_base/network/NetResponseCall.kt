package com.wx.lib_base.network

import okhttp3.Request
import okhttp3.ResponseBody
import okio.Timeout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Converter
import retrofit2.Response
import java.io.IOException
import java.lang.Exception

internal class NetResponseCall<S : Any, E : Any>(
    private val delegate: Call<S>,
    private val errorConverter: Converter<ResponseBody, E>
) : Call<NetResponse<S, E>> {
    override fun enqueue(callback: Callback<NetResponse<S, E>>) =
        delegate.enqueue(object : Callback<S> {
            override fun onFailure(call: Call<S>, t: Throwable) {
                val netResponse = if (t is IOException) {
                    NetResponse.NetError(t)
                } else {
                    NetResponse.UnknownError(t)
                }
                callback.onResponse(this@NetResponseCall, Response.success(netResponse))
            }

            override fun onResponse(call: Call<S>, response: Response<S>) {
                val body = response.body()
                val code = response.code()
                val error = response.errorBody()
                if (response.isSuccessful) {
                    if (body != null) {
                        callback.onResponse(
                            this@NetResponseCall,
                            Response.success(NetResponse.Success(body))
                        )
                    } else {
                        callback.onResponse(
                            this@NetResponseCall,
                            Response.success(NetResponse.UnknownError(null))
                        )
                    }
                } else {
                    val errorBody = when {
                        error == null -> null
                        error.contentLength() == 0L -> null
                        else -> try {
                            errorConverter.convert(error)
                        } catch (e: Exception) {
                            null
                        }
                    }
                    if (errorBody != null) {
                        callback.onResponse(
                            this@NetResponseCall,
                            Response.success(NetResponse.ApiError(errorBody, code))
                        )
                    } else {
                        callback.onResponse(
                            this@NetResponseCall,
                            Response.success(NetResponse.UnknownError(null))
                        )
                    }
                }
            }

        })

    override fun isExecuted(): Boolean = delegate.isExecuted

    override fun timeout(): Timeout = delegate.timeout()

    override fun clone(): Call<NetResponse<S, E>> =
        NetResponseCall(delegate.clone(), errorConverter)

    override fun isCanceled(): Boolean = delegate.isCanceled

    override fun cancel() = delegate.cancel()

    override fun execute(): Response<NetResponse<S, E>> {
        throw UnsupportedOperationException("NetResponseCall doesn't support execute")
    }

    override fun request(): Request = delegate.request()

}