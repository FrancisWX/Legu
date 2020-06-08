package com.wx.gank.ui.fragment

import androidx.viewpager2.widget.ViewPager2
import com.wx.gank.R
import com.wx.lib_base.view.BaseActivity
import com.wx.lib_base.view.BaseFragment

/**
 *Created by wx on 20-5-4
 *Description :
 */
class GalleryFragment : BaseFragment(){

    private lateinit var mViewPager : ViewPager2

    override fun initBeforeView() {
    }

    override fun getContentId(): Int  = R.layout.md_gank_gallery_fragment

    override fun initView() {
    }

    override fun initData() {
    }
}