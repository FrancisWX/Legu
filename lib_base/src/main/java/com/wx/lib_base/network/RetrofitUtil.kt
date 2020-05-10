package com.wx.lib_base.network

import com.wx.lib_base.common.Constants
import okhttp3.ConnectionPool
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 *Created by wx on 19-7-14
 *Description :
 */
object RetrofitUtil {

    private lateinit var mRetrofit: Retrofit

    private val mOkHttpClient : OkHttpClient = OkHttpClient.Builder()
        .connectTimeout(Constants.HTTP_CONNECT_TIME_OUT,TimeUnit.SECONDS)
        .readTimeout(Constants.HTTP_READ_TIME_OUT,TimeUnit.SECONDS)
        .connectionPool(ConnectionPool(Constants.HTTP_CONNECTION_POOL, 5, TimeUnit.MINUTES))
        .build()

    fun getInstance(baseUrl : String) : Retrofit{
        mRetrofit = Retrofit.Builder()
            .baseUrl(baseUrl)
//            .addConverterFactory(GsonConverterFactory.create())
//            .addConverterFactory(ProtoConverterFactory.create())
            .addConverterFactory(MoshiConverterFactory.create())
            .client(mOkHttpClient)
            .build()
        return mRetrofit
    }

}