package com.wx.gank.bean

data class BannerDatas(
    val data: List<BannerData>,
    val status: Int
)

data class BannerData(
    val image: String,
    val title: String,
    val url: String
)