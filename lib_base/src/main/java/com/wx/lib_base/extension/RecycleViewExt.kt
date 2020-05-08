package com.wx.library_common.extension

import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView

/**
 *Created by wx on 19-7-30
 *Description :
 */

fun <T> RecyclerView.Adapter<*>.dataNotify(old: List<T>, new: List<T>, itemCompare: (T, T) -> Boolean, contentCompare : (T,T) -> Boolean) {
    val diff = DiffUtil.calculateDiff(object : DiffUtil.Callback() {

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return itemCompare(old[oldItemPosition], new[newItemPosition])
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return contentCompare(old[oldItemPosition], new[newItemPosition])
        }

        override fun getOldListSize() = old.size

        override fun getNewListSize() = new.size
    })

    diff.dispatchUpdatesTo(this)
}