package com.wx.gank.api

import com.wx.gank.bean.BannerDatas
import com.wx.gank.bean.GankDatas
import com.wx.gank.common.GankConstants
import com.wx.lib_base.network.NetResponse
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *Created by wx on 19-7-14
 *Description :
 */
interface ApiService {

    /**
     * 获取banner数据
     */
    @GET("banners")
    suspend fun getGankBanners(): NetResponse<BannerDatas, Nothing>

    /**
     * 获取干货数据,默认每页15个
     * type : 数据类型
     * page : 页数
     * data/category/Girl/type/Girl/page/1/count/15
     */
    @GET("data/category/{category}/type/{type}/page/{page}/count/${GankConstants.ITEM_PER_PAGE}")
    suspend fun getGankData(@Path("category") category: String, @Path("type") type: String, @Path("page") page: Int): GankDatas

}