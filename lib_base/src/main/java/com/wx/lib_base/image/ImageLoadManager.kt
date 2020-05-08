package com.wx.library_common.image

import android.widget.ImageView
import com.wx.library_common.image.ImageLoadAdapter.GlideImageLoader
import com.wx.library_common.image.ImageLoadAdapter.IImageLoader
import com.wx.library_common.image.ImageLoadAdapter.IImageResLoadListener

/**
 *Created by wx on 19-7-14
 *Description :
 */
object ImageLoadManager {

    private val mImageLoader : IImageLoader  = GlideImageLoader()

    fun loadImage(
        imageView: ImageView,
        url: String, listener: IImageResLoadListener? = null) {
        mImageLoader.loadImage(imageView, url, listener)
    }

    fun loadThumbnail(imageView: ImageView,url : String, listener: IImageResLoadListener? = null) {
        mImageLoader.loadThumbnail(imageView, url, listener)
    }
}