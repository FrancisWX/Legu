package com.wx.wanandroid.bean

/**
 * 公众号数据
 */
data class OfficialAccounts(
    val children: List<Any>,
    val courseId: Int,
    val id: Int,
    val name: String,
    val order: Int,
    val parentChapterId: Int,
    val userControlSetTop: Boolean,
    val visible: Int
)