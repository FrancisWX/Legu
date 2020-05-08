package com.wx.library_common.view

/**
 *Created by wx on 19-12-8
 *Description :
 */
interface BaseFragmentFactory{

    fun getFragmentById( id : Int) : BaseFragment
}