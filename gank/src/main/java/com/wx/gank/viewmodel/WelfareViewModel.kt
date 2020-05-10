package com.wx.gank.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wx.lib_base.extension.requestFromIo
import com.wx.gank.api.GankRepository
import com.wx.gank.bean.GankData
import com.wx.gank.common.GankConstants

/**
 *Created by wx on 20-4-19
 *Description :
 */

class WelfareViewModel : ViewModel() {

    private val mWelfareData : MutableLiveData<MutableList<GankData>> = MutableLiveData()

    private var page : Int = 1;


    fun getWelfareData() : LiveData<MutableList<GankData>> {
        refresh()
        return mWelfareData
    }

    fun refresh() {
        page = 1;
        requestFromIo {
            mWelfareData.postValue(GankRepository.getGankData(GankConstants.GIRL_CATEGORY, GankConstants.GIRL_CONTENT_TYPE, 0))
        }
    }

    fun loadMore() {
        requestFromIo {
            page ++;
            val data = mutableListOf<GankData>()
            mWelfareData.value?.let { data.addAll(it) }
            data.addAll(GankRepository.getGankData(GankConstants.GIRL_CATEGORY, GankConstants.GIRL_CONTENT_TYPE, page))
            mWelfareData.postValue(data)
        }
    }
}