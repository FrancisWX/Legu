package com.wx.lib_base.database

import android.content.Context
import com.wx.lib_base.database.CollectDao
import com.wx.lib_base.database.CollectDatabase
import com.wx.lib_base.database.CollectEntity

/**
 *Created by wx on 19-9-2
 *Description :
 */
class CollectReposity (context: Context) {

    private val mCollectDao : CollectDao by lazy { CollectDatabase.getInstance(context).collectDao() }

    /**
     * 获取收藏列表数据
     */
    fun getCollects() = mCollectDao.getCollects()

    /**
     * 插入收藏项
     */
    suspend fun insertCollect(collect : CollectEntity){
        mCollectDao.insertCollect(collect)
    }

    /**
     * 移除收藏项
     */
    suspend fun removeCollect(collect : CollectEntity){
        mCollectDao.removeCollect(collect)
    }

    /**
     * 清空收藏列表
     */
    suspend fun emptyCollects(){

    }
}