package com.wx.gank.api

import com.wx.lib_base.network.RetrofitUtil
import com.wx.gank.bean.BannerDatas
import com.wx.gank.bean.GankData
import com.wx.gank.common.GankConstants


/**
 *Created by wx on 19-7-14
 *Description :
 */
object GankRepository{

    private var gankService : ApiService = RetrofitUtil.getInstance(GankConstants.GANK_BASE_URL)
        .create(ApiService::class.java)

    suspend fun getGankData(category : String, type : String,page : Int) : MutableList<GankData> = apiCall{
        val data = gankService.getGankData(category,type,page)
        data.data
    }


    suspend fun getBannerData()  = gankService.getGankBanners()

    private suspend fun apiCall(call : suspend() -> MutableList<GankData>) : MutableList<GankData> {
        return call.invoke()
    }

}