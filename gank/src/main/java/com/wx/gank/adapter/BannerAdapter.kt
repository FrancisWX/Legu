package com.wx.gank.adapter

import android.content.Context
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.DiffUtil
import com.wx.gank.R
import com.wx.lib_base.image.ImageLoadManager
import com.wx.lib_base.view.BaseListAdapter
import com.wx.lib_base.view.BaseViewHolder
import com.wx.gank.bean.BannerData

/**
 *Created by wx on 20-4-6
 *Description :
 */
class BannerAdapter(mContext: Context) : BaseListAdapter<BannerData>(
    mContext,
    R.layout.md_gank_layout_item_banner,
    DIFF_CALLBACK
) {
    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<BannerData>() {
            override fun areItemsTheSame(oldItem: BannerData, newItem: BannerData): Boolean =
                oldItem.image == newItem.image

            override fun areContentsTheSame(oldItem: BannerData, newItem: BannerData): Boolean =
                oldItem.url == newItem.url

        }
    }

    override fun realBindViewHolder(holder: BaseViewHolder, position: Int) {
        val cover = holder.getView<AppCompatImageView>(R.id.cover_banner_item_md_gank)

        ImageLoadManager.loadImage(cover, getItem(position).image)
    }
}