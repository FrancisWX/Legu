package com.wx.gank.adapter

import android.content.Context
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import com.wx.gank.R
import com.wx.lib_base.image.ImageLoadAdapter.IImageResLoadListener
import com.wx.lib_base.image.ImageLoadManager
import com.wx.lib_base.view.BaseListAdapter
import com.wx.lib_base.view.BaseViewHolder
import com.wx.gank.bean.GankData

/**
 *Created by wx on 20-5-4
 *Description :
 */
class GankDataAdapter (
    context : Context
) : BaseListAdapter<GankData>(
    context,
    R.layout.md_gank_recycler_view_item,
    DIFF_CALLBACK
) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<GankData>() {

            override fun areItemsTheSame(oldItem: GankData, newItem: GankData): Boolean =
                oldItem._id == newItem._id

            override fun areContentsTheSame(oldItem: GankData, newItem: GankData): Boolean =
                oldItem.images == newItem.images
        }
    }

    override fun realBindViewHolder(holder: BaseViewHolder, position: Int) {
        val data = getItem(position)
        val title : TextView = holder.getView(R.id.tv_title_module_gank_item_view)
        title.text = data.desc
        val subtitle : TextView = holder.getView(R.id.tv_sub_title_module_gank_item_view)
        subtitle.text = data.author

        val preView : ImageView = holder.getView(R.id.iv_preview_module_gank_item_view)


        if (data.images.size > 0) {
            ImageLoadManager.loadImage(preView, data.images[0], object :
                IImageResLoadListener {
                override fun onLoadFailed(e: Exception?) {
                }

                override fun onResReady() {
                }

            })
        }



    }
}