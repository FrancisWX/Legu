package com.wx.lib_base.update.updater

import com.wx.lib_base.update.updater.IApkDownloadCallback
import com.wx.lib_base.update.updater.IAppUpdater
import com.wx.lib_base.update.updater.IVersionRequestCallback
import java.io.File

/**
 *Created by wx on 19-9-4
 *Description :
 */

class RetrofitUpdater : IAppUpdater {
    override fun requestVersion(url: String, callBack: IVersionRequestCallback) {
    }

    override fun downloadApk(url: String, targetFile: File, callBack: IApkDownloadCallback) {
    }

}