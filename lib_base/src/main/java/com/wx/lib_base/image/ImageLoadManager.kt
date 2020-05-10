package com.wx.lib_base.image

import android.widget.ImageView
import com.wx.lib_base.image.ImageLoadAdapter.GlideImageLoader
import com.wx.lib_base.image.ImageLoadAdapter.IImageLoader
import com.wx.lib_base.image.ImageLoadAdapter.IImageResLoadListener

/**
 *Created by wx on 19-7-14
 *Description :
 */
object ImageLoadManager {

    private val mImageLoader : IImageLoader = GlideImageLoader()

    fun loadImage(
        imageView: ImageView,
        url: String, listener: IImageResLoadListener? = null) {
        mImageLoader.loadImage(imageView, url, listener)
    }

    fun loadThumbnail(imageView: ImageView,url : String, listener: IImageResLoadListener? = null) {
        mImageLoader.loadThumbnail(imageView, url, listener)
    }
}