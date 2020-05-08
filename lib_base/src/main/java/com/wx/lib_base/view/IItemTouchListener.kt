package com.wx.library_common.view

import android.view.GestureDetector
import android.view.MotionEvent
import androidx.recyclerview.widget.RecyclerView

/**
 *Created by wx on 19-7-14
 *Description :
 */
open class IItemTouchListener : RecyclerView.OnItemTouchListener{

    private lateinit var mGestureDetector: GestureDetector
    private lateinit var mRecyclerView: RecyclerView

    override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
        mRecyclerView = rv
        mGestureDetector = GestureDetector(rv.context,getSimpleGestureListener())
    }

    override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
        return mGestureDetector.onTouchEvent(e)
    }

    override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {

    }

    private fun getSimpleGestureListener() : GestureDetector.SimpleOnGestureListener{
        return object : GestureDetector.SimpleOnGestureListener(){
            override fun onSingleTapUp(e: MotionEvent?): Boolean {
                e?.let {
                    val view = mRecyclerView.findChildViewUnder(e.x,e.y)
                    view?.let {
                        val viewHolder = mRecyclerView.getChildViewHolder(view)
                        onItemClicked(viewHolder)
                    }
                }
                return true
            }

            override fun onLongPress(e: MotionEvent?) {
                e?.let {
                    val view = mRecyclerView.findChildViewUnder(e.x,e.y)
                    view?.let {
                        val viewHolder = mRecyclerView.getChildViewHolder(view)
                        onItemLongClicked(viewHolder)
                    }
                }
            }
        }
    }

    /**
     * 列表项点击事件
     */
    open fun onItemClicked(holder: RecyclerView.ViewHolder){

    }

    /**
     * 列表项长按事件
     */
    open fun onItemLongClicked(holder: RecyclerView.ViewHolder){

    }

}