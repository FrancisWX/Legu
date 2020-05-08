package com.wx.library_common.image.ImageLoadAdapter

import android.widget.ImageView

/**
 *Created by wx on 19-9-22
 *Description :
 */
interface IImageLoader {
    /**
     * 加载图片
     */
    fun loadImage(
        imageView: ImageView,
        url: String, listener: IImageResLoadListener?
    )

    /**
     * 加载缩略图
     */
    fun loadThumbnail(
        imageView: ImageView,
        url: String, listener: IImageResLoadListener?)
}