package com.wx.library_common.image.ImageLoadAdapter

/**
 *Created by wx on 20-4-12
 *Description :
 */
interface IImageResLoadListener {

    /**
     * 图片加载失败
     */
    fun onLoadFailed(e : Exception?)

    /**
     * 图片已准备完成
     */
    fun onResReady()
}