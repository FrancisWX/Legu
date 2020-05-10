package com.wx.lib_base.view

import android.view.View
import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView

/**
 *Created by wx on 19-7-8
 *Description :
 */
open class BaseViewHolder(private val item : View) : RecyclerView.ViewHolder(item) {

    private val mViews  = SparseArrayCompat<View>()

    @Suppress("UNCHECKED_CAST")
    fun < V : View> getView(id : Int): V{
        var view : View? = mViews[id]
        if(view == null){
         view = item.findViewById(id)
         mViews.put(id,view)
        }
        return view as V
    }
}