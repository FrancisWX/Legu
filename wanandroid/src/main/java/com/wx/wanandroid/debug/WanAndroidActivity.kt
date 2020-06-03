package com.wx.wanandroid.debug

import androidx.fragment.app.commit
import com.wx.lib_base.view.BaseActivity
import com.wx.wanandroid.R
import com.wx.wanandroid.fragment.WanAndroidFragment

/**
 *Created by wx on 20-3-1
 *Description :
 */
class WanAndroidActivity : BaseActivity() {


    override fun initBeforeView() {

    }

    override fun getContentId(): Int = R.layout.md_wanandroid_main_activity

    override fun initView() {

        supportFragmentManager.commit {
            replace(R.id.root_layout_activity_main_module_wanandroid, WanAndroidFragment())
        }
    }

    override fun initData() {
    }


}