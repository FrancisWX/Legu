package com.wx.lib_base.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

/**
 *Created by wx on 19-7-8
 *Description : Fragment基类
 */
abstract class BaseFragment : Fragment(),IVIewInit{

    protected lateinit var mRootView : View
    protected lateinit var mContext : Context

    override fun onAttach(context: Context) {
        super.onAttach(context)
        mContext = context
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initBeforeView()
        mRootView = inflater.inflate(getContentId(),container,false)
        return mRootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initData()
    }




}