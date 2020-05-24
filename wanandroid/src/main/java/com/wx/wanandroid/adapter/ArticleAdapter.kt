package com.wx.wanandroid.adapter

import android.content.Context
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.DiffUtil
import com.wx.library_common.view.BaseListAdapter
import com.wx.library_common.view.BaseViewHolder
import com.wx.module_wanandroid.R
import com.wx.module_wanandroid.bean.Article

/**
 *Created by wx on 20-3-29
 *Description :
 */
class ArticleAdapter(context: Context) : BaseListAdapter<Article>(
    context,
    R.layout.md_wanandroid_layout_article_item,
    DIFF_CALLBACK
) {

    companion object {
        val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Article>() {
            override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean =
                oldItem.link == newItem.link
        }
    }

    override fun realBindViewHolder(holder: BaseViewHolder, position: Int) {
        val title = holder.getView<AppCompatTextView>(R.id.title_tv_article_item_module_wanandroid)
        title.text = getItem(position).title
    }


}