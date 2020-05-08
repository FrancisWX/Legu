package com.wx.library_common.util

import com.wx.library_common.common.Constants
import com.wx.library_common.network.BaseResponse
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