package com.wx.library_common.view

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

/**
 *Created by wx on 20-3-29
 *Description :
 */
abstract class BaseListAdapter<T> (
    val context : Context,
    private val layoutRes : Int,
    DIFF_CALLBACK : DiffUtil.ItemCallback<T>
) : ListAdapter<T,BaseViewHolder>(DIFF_CALLBACK){

    var mItemClick : ((pos : Int) -> Unit) ? = null
    var mItemLongClick : ((pos : Int) -> Boolean) ? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder =
        BaseViewHolder(LayoutInflater.from(context).inflate(layoutRes, parent, false))

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            mItemClick?.apply {
                invoke(position)
            }
        }
        holder.itemView.setOnLongClickListener {
            mItemLongClick?.apply {
                invoke(position)
            }
            return@setOnLongClickListener false
        }
        realBindViewHolder(holder, position)
    }

    abstract fun realBindViewHolder(holder: BaseViewHolder, position: Int)
}