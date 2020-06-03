package com.wx.wanandroid.viewmodel

import androidx.lifecycle.MutableLiveData
import com.wx.lib_base.data.BaseViewModel
import com.wx.module_wanandroid.bean.ArticleList
import com.wx.module_wanandroid.bean.BannerData
import com.wx.module_wanandroid.repository.NetDataRepository

/**
 *Created by wx on 20-3-28
 *Description :
 */
class HomeViewModel : BaseViewModel(){

    /**
     * 首页Banner数据
     */
    private val mBannerDatas : MutableLiveData<List<BannerData>> = MutableLiveData()
    /**
     * 首页文章列表数据
     */
    private val mHomeDatas : MutableLiveData<ArticleList> = MutableLiveData()


    init {

        requestFromIO {
            mBannerDatas.postValue(NetDataRepository.getBannerData())
            mHomeDatas.postValue(NetDataRepository.getHomeArticles(0))
        }
    }


    fun getBannerDatas() = mBannerDatas

    fun getHomeArticleDatas() = mHomeDatas



}