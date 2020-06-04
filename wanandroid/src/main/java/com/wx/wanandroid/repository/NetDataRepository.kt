package com.wx.wanandroid.repository

import com.wx.lib_base.network.RetrofitUtil
import com.wx.wanandroid.api.WanAndroidService
import com.wx.wanandroid.bean.ArticleList
import com.wx.wanandroid.bean.BannerData
import com.wx.wanandroid.common.Constants

/**
 *Created by wx on 20-3-29
 *Description :
 */
object NetDataRepository {

    private var service = RetrofitUtil.getInstance(Constants.BASE_URL_WAN_ANDROID)
        .create(WanAndroidService::class.java)


    suspend fun getBannerData() : List<BannerData> = service.getBannerData().data

    suspend fun getHomeArticles(page : Int) : ArticleList = service.getHomePageData(page).data
}