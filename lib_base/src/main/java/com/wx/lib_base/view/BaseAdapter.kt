package com.wx.lib_base.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView

/**
 *Created by wx on 19-7-8
 *Description : RecycleView列表适配器通用类
 */
abstract class BaseAdapter<T>(
    private val context: Context,
    private val layoutRes: Int,
    protected val mHeadView: View? = null,
    protected val mFootView: View? = null
) : RecyclerView.Adapter<BaseViewHolder>() {
    companion object{
        const val TYPE_HEADER : Int = 0
        const val TYPE_NORMAL : Int = 1
        const val TYPE_FOOTER : Int = 2
    }
    private val mItemClick : ((position : Int) -> Unit)? = null
    private val mItemLongClick : ((position : Int) -> Boolean)? = null

    override fun onBindViewHolder(holder: BaseViewHolder, position: Int) {
        holder.itemView.setOnClickListener {
            mItemClick?.apply {
                if(mHeadView == null){
                    invoke(position)
                } else {
                    invoke(position - 1)
                }
            }
        }
        holder.itemView.setOnLongClickListener {
            mItemLongClick?.apply {
                if(mHeadView != null){
                    invoke(position)
                }else{
                    invoke(position - 1)
                }
            }
            return@setOnLongClickListener false
        }
        if(getItemViewType(position) == TYPE_NORMAL){
            realBindViewHolder(holder,position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder {
        return when{
            mHeadView != null && viewType == TYPE_HEADER -> BaseViewHolder(mHeadView)
            mFootView != null && viewType == TYPE_FOOTER -> BaseViewHolder(mFootView)
            else -> BaseViewHolder(LayoutInflater.from(context).inflate(layoutRes,parent,false))
        }
    }

    override fun getItemCount(): Int {
        return getCount()
    }

    override fun getItemViewType(position: Int): Int {
        mHeadView?.let {
            if(position == 0){
                return TYPE_HEADER
            }
        }
        mFootView?.let {
            if(position == itemCount -1){
                return TYPE_FOOTER
            }
        }
        return TYPE_NORMAL
    }

    abstract fun realBindViewHolder(holder: BaseViewHolder,position: Int)

    abstract fun updateData(datas : List<T>)

    abstract fun getCount() : Int
}