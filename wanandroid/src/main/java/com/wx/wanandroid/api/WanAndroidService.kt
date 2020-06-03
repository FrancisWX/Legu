package com.wx.wanandroid.api

import com.wx.lib_base.network.BaseResponse
import com.wx.module_wanandroid.bean.ArticleList
import com.wx.module_wanandroid.bean.BannerData
import com.wx.module_wanandroid.bean.OfficialAccounts
import com.wx.module_wanandroid.bean.Project
import retrofit2.http.GET
import retrofit2.http.Path

/**
 *Created by wx on 20-3-8
 *Description :
 */
interface WanAndroidService {


    /**
     * 获取首页banner数据
     */
    @GET("banner/json")
    suspend fun getBannerData() : BaseResponse<List<BannerData>>

    /**
     * 获取首页文章列表
     * @param page 页数(0~)
     */
    @GET("article/list/{page}/json")
    suspend fun getHomePageData(@Path("page") page : Int) : BaseResponse<ArticleList>

    /**
     * 获取项目列表
     */
    @GET("project/tree/json")
    suspend fun getProjectData() : BaseResponse<List<Project>>

    /**
     * 获取广场文章列表
     * @param page 页码(0~)
     */
    @GET("user_article/list/{page}/json")
    suspend fun getSquareData(@Path("page") page : Int) : BaseResponse<ArticleList>

    /**
     * 获取公众号列表
     */
    @GET("wxarticle/chapters/json")
    suspend fun getOfficialAccounts() : BaseResponse<List<OfficialAccounts>>

    /**
     * 获取特定公众号文章列表
     */
    @GET("wxarticle/list/{officialId}/{page}/json")
    suspend fun getOfficialData(@Path("officialId") officialId : Int, @Path("page") page : Int) : BaseResponse<ArticleList>


}