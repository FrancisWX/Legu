package com.wx.lib_base.extension

import kotlinx.coroutines.*
import kotlin.coroutines.CoroutineContext

/**
 *Created by wx on 20-5-10
 *Description :
 */

fun <T> executeRequest(context : CoroutineContext, request: suspend () -> T?, onSuccess: (T) -> Unit = {}, onFail: (Throwable) -> Unit = {}): Job {
    return CoroutineScope(Dispatchers.Main).launch(context) {
        try {
            val res: T? = withContext(Dispatchers.IO) { request() }
            res?.let {
                onSuccess(it)
            }
        } catch (e: Exception) {
            e.printStackTrace()
            onFail(e)
        }
    }
}