package com.wx.lib_base.view

/**
 *Created by wx on 19-7-8
 *Description :
 */
interface IVIewInit {
    /**
     * 在View前的初始化
     */
    fun initBeforeView() : Unit
    /**
     * 获取布局ID
     */
    fun getContentId() : Int
    /**
     * 初始化View,绑定控件
     */
    fun initView() : Unit
    /**
     * 初始化数据
     */
    fun initData() : Unit
}