package com.wx.wanandroid.adapter

import android.content.Context
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import com.wx.library_common.image.ImageLoadManager
import com.wx.library_common.view.BaseListAdapter
import com.wx.library_common.view.BaseViewHolder
import com.wx.module_wanandroid.R
import com.wx.module_wanandroid.bean.BannerData

/**
 *Created by wx on 20-3-29
 *Description :
 */
class BannerAdapter(
    mContext: Context
) : BaseListAdapter<BannerData>(
    mContext,
    R.layout.md_wanandroid_layout_banner_item,
    DIFF_CALLBACK
) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<BannerData>() {
            override fun areItemsTheSame(oldItem: BannerData, newItem: BannerData): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: BannerData, newItem: BannerData): Boolean =
                oldItem.imagePath == newItem.imagePath
        }
    }

    override fun realBindViewHolder(holder: BaseViewHolder, position: Int) {
        val cover =
            holder.getView<AppCompatImageView>(R.id.cover_img_banner_item_module_wanandroid)
        val title = holder.getView<AppCompatTextView>(R.id.title_tv_banner_item_module_wanandroid)

        title.text = getItem(position).desc
        ImageLoadManager.loadImage(cover, getItem(position).imagePath)
    }
}