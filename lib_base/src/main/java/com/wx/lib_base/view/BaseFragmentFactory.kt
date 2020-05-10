package com.wx.lib_base.view

/**
 *Created by wx on 19-12-8
 *Description :
 */
interface BaseFragmentFactory{

    fun getFragmentById( id : Int) : BaseFragment
}