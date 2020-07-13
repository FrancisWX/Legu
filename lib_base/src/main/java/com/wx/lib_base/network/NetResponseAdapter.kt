package com.wx.lib_base.network

import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Converter
import java.lang.reflect.Type

class NetResponseAdapter<S : Any, E : Any> (
    private val successType: Type,
    private val errorBodyConverter: Converter<ResponseBody, E>
) : CallAdapter<S, Call<NetResponse<S, E>>> {

    override fun adapt(call: Call<S>): Call<NetResponse<S, E>> = NetResponseCall(call, errorBodyConverter)

    override fun responseType(): Type = successType

}