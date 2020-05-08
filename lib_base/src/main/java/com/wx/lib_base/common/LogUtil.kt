package com.wx.library_common.common

import android.util.Log

/**
 *Created by wx on 19-7-17
 *Description :
 */
object LogUtil {

    /**
     * 日志记录开关
     */
    const val WRITE_LOG_ENABLE = true

    const val TAG = "LogUtil"
    const val VERBOSE : Int = 2
    const val DEBUG : Int = 3
    const val INFO : Int = 4
    const val WARN : Int = 5
    const val ERROR : Int = 6
    const val ASSERT : Int = 7

    fun v(msg: String){
        log(VERBOSE,TAG,msg)
    }
    fun v(TAG: String,msg: String){
        log(VERBOSE,TAG,msg)
    }
    fun d(msg: String){
        log(DEBUG, TAG,msg)
    }
    fun d(TAG: String,msg: String){
        log(DEBUG,TAG,msg)
    }
    fun i(msg: String){
        log(INFO, TAG,msg)
    }
    fun i(TAG: String,msg: String){
        log(INFO,TAG,msg)
    }
    fun w(msg: String){
        log(WARN, TAG,msg)
    }
    fun w(TAG: String,msg: String){
        log(WARN,TAG,msg)
    }
    fun e(msg: String){
        log(ERROR, TAG,msg)
    }
    fun e(TAG: String,msg: String){
        log(ERROR,TAG,msg)
    }

    fun log(priority : Int,TAG : String,msg : String){

        if(priority < ERROR && !BuildConfig.DEBUG){
            return
        }
        if (WRITE_LOG_ENABLE) {

            val stackTrace = Thread.currentThread().stackTrace
            val stackOffset = getStackOffset(stackTrace)
            val message =
                "${getSimpleClassName(stackTrace[stackOffset].className)}.${stackTrace[stackOffset].methodName}: $msg (${stackTrace[stackOffset].fileName}:${stackTrace[stackOffset].lineNumber})"
            Log.println(priority, TAG, message)
        }
    }


    private fun getStackOffset(trace: Array<StackTraceElement>): Int {
        var offset = 0
        var flag = false

        while (offset < trace.size) {
            val e = trace[offset]
            val name = e.className

            if (!flag) {
                if (name == LogUtil::class.java.name) {
                    flag = true
                }
            } else {
                if (name != LogUtil::class.java.name) {
                    return offset
                }
            }
            offset++
        }

        return 0
    }

    private fun getSimpleClassName(name: String): String {
        val lastIndex = name.lastIndexOf(".")
        return name.substring(lastIndex + 1)
    }
}