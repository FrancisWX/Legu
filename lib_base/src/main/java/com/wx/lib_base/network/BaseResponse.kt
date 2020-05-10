package com.wx.lib_base.network

/**
 *Created by wx on 19-7-14
 *Description :
 */
data class BaseResponse<T>(
    val data : T,
    val errorCode : Int,
    val errorMsg : String
)