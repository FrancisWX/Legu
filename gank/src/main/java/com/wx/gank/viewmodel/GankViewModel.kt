package com.wx.gank.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wx.lib_base.common.LogUtil
import com.wx.gank.api.GankRepository
import com.wx.gank.bean.BannerDatas
import com.wx.gank.bean.GankData
import com.wx.gank.common.GankConstants
import com.wx.lib_base.network.NetResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 *Created by wx on 19-7-21
 *Description :
 */

class GankViewModel : ViewModel(){

    private val mBannerData : MutableLiveData<BannerDatas> = MutableLiveData()
    private var mAndroidPage = GankConstants.NUM_START_PAGE
    private val mAndroidData : MutableLiveData<List<GankData>> = MutableLiveData()
    private var mIosPage = GankConstants.NUM_START_PAGE
    private val mIosData : MutableLiveData<List<GankData>> = MutableLiveData()
    private var mWebPage = GankConstants.NUM_START_PAGE
    private val mWebData : MutableLiveData<List<GankData>> = MutableLiveData()
    private var mFlutterPage = GankConstants.NUM_START_PAGE
    private val mFlutterData : MutableLiveData<List<GankData>> = MutableLiveData()

    init {
        requestBannerData()
    }

    fun getBannerDatas() : LiveData<BannerDatas> = mBannerData

    fun getAndroidData() : LiveData<List<GankData>>{
        refresh(GankConstants.ANDROID_CONTENT_TYPE)
        return mAndroidData
    }

    fun getIosData(page : Int) : LiveData<List<GankData>>{
        refresh(GankConstants.IOS_CONTENT_TYPE)
        return mIosData
    }

    fun getWebData(page : Int) : LiveData<List<GankData>>{
        refresh(GankConstants.WEB_CONTENT_TYPE)
        return mWebData
    }

    fun getFlutterData() : LiveData<List<GankData>> {
        refresh(GankConstants.FLUTTER_CONTENT_TYPE)
        return mFlutterData
    }


    fun refresh(type: String) {
        loadData(type, true)
    }

    fun loadMore(type: String) {
        loadData(type, false)
    }

    private fun loadData(type: String, isRefresh : Boolean) {
        when (type) {
            GankConstants.ANDROID_CONTENT_TYPE -> {
                if (isRefresh) {
                    mAndroidPage = GankConstants.NUM_START_PAGE
                } else {
                    mAndroidPage ++
                }
                mAndroidData.requestData(
                    GankConstants.GANHUO_CATEGORY,
                    GankConstants.ANDROID_CONTENT_TYPE,mAndroidPage, isRefresh)
            }
            GankConstants.IOS_CONTENT_TYPE -> {
                if (isRefresh) {
                    mIosPage = GankConstants.NUM_START_PAGE
                } else {
                    mIosPage ++
                }
                mIosData.requestData(GankConstants.GANHUO_CATEGORY, GankConstants.IOS_CONTENT_TYPE,mIosPage, isRefresh)
            }
            GankConstants.WEB_CONTENT_TYPE -> {
                if (isRefresh) {
                    mWebPage = GankConstants.NUM_START_PAGE
                } else {
                    mWebPage ++
                }
                mWebData.requestData(GankConstants.GANHUO_CATEGORY, GankConstants.WEB_CONTENT_TYPE, mWebPage, isRefresh)
            }
            GankConstants.FLUTTER_CONTENT_TYPE -> {
                if (isRefresh) {
                    mFlutterPage = GankConstants.NUM_START_PAGE
                } else {
                    mFlutterPage ++
                }
                mFlutterData.requestData(GankConstants.GANHUO_CATEGORY, GankConstants.FLUTTER_CONTENT_TYPE, mFlutterPage, isRefresh)
            }
        }
    }


    private fun MutableLiveData<List<GankData>>.requestData(category : String, type : String, page : Int, isRefresh: Boolean): MutableLiveData<List<GankData>> {
        viewModelScope.launch (Dispatchers.IO) {
            val data = mutableListOf<GankData>()
            LogUtil.d("page = $page,  isRefresh = $isRefresh")
            if (!isRefresh) {
                value?.let {
                    data.addAll(it)
                }
            }
            data.addAll(GankRepository.getGankData(category, type, page))
            postValue(data)
        }
        return this
    }

    private fun requestBannerData() {
        viewModelScope.launch (Dispatchers.IO) {
            when (val response =  GankRepository.getBannerData()) {
                is NetResponse.Success -> mBannerData.postValue(response.body)
                is NetResponse.ApiError -> LogUtil.d("request banner api error")
                is NetResponse.NetError -> LogUtil.d("request banner net error")
                is NetResponse.UnknownError -> LogUtil.d("request banner unknown error")
            }
        }
    }

}