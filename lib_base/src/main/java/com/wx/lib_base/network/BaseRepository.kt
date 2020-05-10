package com.wx.lib_base.network

/**
 *Created by wx on 19-7-14
 *Description :
 */
open class BaseRepository{
    suspend fun <T : Any> apiCall(call : suspend() -> Unit ) {
        call.invoke()
    }
}