package com.wx.library_common.common

/**
 *Created by wx on 19-7-14
 *Description :
 */

object Constants {

    //网络相关
    const val ERROR_CODE : Int = -1
    const val SUCCESS_CODE : Int = 200
    const val HTTP_CONNECT_TIME_OUT = 60L
    const val HTTP_READ_TIME_OUT = 100L
    const val HTTP_CONNECTION_POOL = 32

    //数据库相关
    const val COLLECT_DATABASE_VERSION = 1
    const val COLLECT_DATABASE_NAME = "collects.db"

    //图片加载相关
    const val THUMBNAIL_FACTOR = .2f
}