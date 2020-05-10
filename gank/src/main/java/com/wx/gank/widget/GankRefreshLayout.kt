package com.wx.gank.widget

import android.content.Context
import android.util.AttributeSet
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import android.view.ViewGroup



/**
 *Created by wx on 19-10-16
 *Description :
 */
class GankRefreshLayout @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : SmartRefreshLayout(context, attrs) {


    init {
        val layoutParams = ViewGroup.LayoutParams(
            ViewGroup.LayoutParams.MATCH_PARENT,
            ViewGroup.LayoutParams.WRAP_CONTENT
        )

    }
}