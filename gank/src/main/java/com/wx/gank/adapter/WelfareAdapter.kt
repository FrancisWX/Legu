package com.wx.gank.adapter

import android.content.Context
import androidx.appcompat.widget.AppCompatImageView
import androidx.recyclerview.widget.DiffUtil
import com.wx.gank.R
import com.wx.lib_base.common.LogUtil
import com.wx.lib_base.image.ImageLoadAdapter.IImageResLoadListener
import com.wx.lib_base.image.ImageLoadManager
import com.wx.lib_base.view.BaseListAdapter
import com.wx.lib_base.view.BaseViewHolder
import com.wx.gank.bean.GankData
import io.supercharge.shimmerlayout.ShimmerLayout

/**
 *Created by wx on 19-10-5
 *Description :
 */
class WelfareAdapter(
    mContext: Context
) : BaseListAdapter<GankData>(
    mContext,
    R.layout.md_gank_layout_item_welfare_fragment,
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
    val shimmer = holder.getView<ShimmerLayout>(R.id.shimmer_layout_item_welfare_fragment)
    shimmer.apply {
        setShimmerColor(0xFFFAF0)
        setShimmerAngle(0)
        startShimmerAnimation()
    }
    val image = holder.getView<AppCompatImageView>(R.id.iv_photo_layout_item_welfare_fragment)

    ImageLoadManager.loadImage(image, getItem(position).images[0], object : IImageResLoadListener {
        override fun onLoadFailed(e: Exception?) {
            LogUtil.d(e.toString())
        }

        override fun onResReady() {
            shimmer.stopShimmerAnimation()
        }
    })
}


}