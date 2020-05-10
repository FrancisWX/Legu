package com.wx.gank.debug

import android.app.Application
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.constant.SpinnerStyle
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.wx.gank.R

/**
 *Created by wx on 20-2-29
 *Description :
 */

class GankDebugApplication : Application(){


    override fun onCreate() {
        super.onCreate()

        configSmartRefreshLayout()

    }

    private fun configSmartRefreshLayout() {

        SmartRefreshLayout.setDefaultRefreshHeaderCreator{ context, layout ->
            layout.setPrimaryColorsId(R.color.black, android.R.color.white);
            ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.Translate);
        }

        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout ->
            ClassicsFooter(context).setSpinnerStyle(SpinnerStyle.Translate);
        }
    }
}