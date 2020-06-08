package com.wx.gank.debug

import com.wx.gank.R
import com.wx.lib_base.view.BaseActivity
import com.wx.gank.ui.fragment.GankFragment

/**
 *Created by wx on 19-7-21
 *Description :
 */
class GankActivity : BaseActivity(){

    override fun initBeforeView() {
    }

    override fun getContentId(): Int {
        return R.layout.md_gank_main_activity
    }

    override fun initView() {

        supportFragmentManager.beginTransaction()
            .replace(R.id.root_content_module_gank_main_activity,
                GankFragment()
            )
            .commit()
    }

    override fun initData() {


    }

}