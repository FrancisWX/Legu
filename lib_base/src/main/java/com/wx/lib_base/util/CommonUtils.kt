package com.wx.lib_base.util

import com.wx.lib_base.common.Constants
import com.wx.lib_base.network.BaseResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.coroutineScope

/**
 *Created by wx on 19-7-14
 *Description :公共函数
 */

//协程请求结果响应
suspend fun execResponse(response: BaseResponse<Any>, successBlock: suspend CoroutineScope.() -> Unit,
                         errorBlock: suspend CoroutineScope.() -> Unit) {
    coroutineScope {
        if (response.errorCode == Constants.ERROR_CODE) {
            errorBlock()
        } else {
            successBlock()
        }
    }
}