package com.wx.wanandroid.fragment

import androidx.navigation.Navigation
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.wx.lib_base.view.BaseFragment
import com.wx.wanandroid.R

/**
 *Created by wx on 20-3-8
 *Description : 主界面
 */
class WanAndroidFragment : BaseFragment() {

    override fun initBeforeView() {
    }

    override fun getContentId(): Int = R.layout.md_wanandroid_main_fragment

    override fun initView() {

        val naviController = Navigation.findNavController(requireActivity(), R.id.fragment_nav_host_main_fragment_module_wanandroid)
        val bottomNavi =
            view?.findViewById<BottomNavigationView>(R.id.view_navi_main_fragment_module_wanandroid)

        bottomNavi?.setupWithNavController(naviController)
    }

    override fun initData() {
    }

}