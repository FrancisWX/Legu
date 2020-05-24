package com.wx.wanandroid.repository

import com.wx.library_common.network.RetrofitUtil
import com.wx.module_wanandroid.api.WanAndroidService
import com.wx.module_wanandroid.bean.ArticleList
import com.wx.module_wanandroid.bean.BannerData
import com.wx.module_wanandroid.common.Constants

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