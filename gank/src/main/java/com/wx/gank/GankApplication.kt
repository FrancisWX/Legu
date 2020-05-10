package com.wx.gank

import android.app.Application
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.scwang.smartrefresh.layout.constant.SpinnerStyle
import com.scwang.smartrefresh.layout.footer.ClassicsFooter
import com.scwang.smartrefresh.layout.header.ClassicsHeader
import com.wx.lib_base.application.IModuleApplication

/**
 *Created by wx on 19-10-8
 *Description :
 */
class GankApplication : IModuleApplication {


    override fun initConfig(application: Application) {

        configSmartRefreshLayout()
    }


    private fun configSmartRefreshLayout() {

        SmartRefreshLayout.setDefaultRefreshHeaderCreator{ context, layout ->
            layout.setPrimaryColorsId(R.color.black, android.R.color.white);//全局设置主题颜色
            ClassicsHeader(context).setSpinnerStyle(SpinnerStyle.Translate);
        }

        SmartRefreshLayout.setDefaultRefreshFooterCreator { context, layout ->
             ClassicsFooter(context).setSpinnerStyle(SpinnerStyle.Translate);
        }
    }

}