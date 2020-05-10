package com.wx.gank.bean

/**
 *Created by wx on 19-7-14
 *Description :
 */
data class GankResult(
    val error: Boolean,
    val results: List<GankBean>
)

data class GankBean(
    val _id: String,
    val createdAt: String,
    val desc: String,
    val images: List<String>,
    val publishedAt: String,
    val source: String,
    val type: String,
    val url: String,
    val used: Boolean,
    val who: String
){
    override fun toString(): String {
        return "id = $_id  desc = $desc"
    }
}