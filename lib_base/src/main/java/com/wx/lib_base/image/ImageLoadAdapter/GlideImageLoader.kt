package com.wx.library_common.image.ImageLoadAdapter

import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import com.wx.library_common.common.Constants

/**
 *Created by wx on 19-9-22
 *Description :
 */
class GlideImageLoader : IImageLoader{

    override fun loadImage(
        imageView: ImageView,
        url: String, listener: IImageResLoadListener?
    ) {
        Glide.with(imageView.context)
            .load(url)
            .addListener(object : RequestListener<Drawable>{
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    listener?.onLoadFailed(e)
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    listener?.onResReady()
                    return false
                }

            })
            .into(imageView)
    }

    override fun loadThumbnail(
        imageView: ImageView,
        url: String, listener: IImageResLoadListener?
    ) {
        Glide.with(imageView.context)
            .load(url)
            .addListener(object : RequestListener<Drawable>{
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable>?,
                    isFirstResource: Boolean
                ): Boolean {
                    listener?.onLoadFailed(e)
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    listener?.onResReady()
                    return false
                }

            })
            .thumbnail(Constants.THUMBNAIL_FACTOR)
            .into(imageView)
    }

}