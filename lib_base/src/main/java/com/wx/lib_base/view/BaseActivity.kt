package com.wx.library_common.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 *Created by wx on 19-7-8
 *Description : Activity基类
 */
abstract class BaseActivity : AppCompatActivity(),IVIewInit{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initBeforeView()
        setContentView(getContentId())
        initView()
        initData()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}