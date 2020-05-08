package com.wx.library_common.app_update.updater

import java.io.File

/**
 *Created by wx on 19-9-4
 *Description :
 */
interface IAppUpdater {

    fun requestVersion(url : String, callBack : IVersionRequestCallback)

    fun downloadApk(url : String, targetFile : File, callBack : IApkDownloadCallback)
}