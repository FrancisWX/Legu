package com.wx.library_common.database

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*

/**
 *Created by wx on 19-9-2
 *Description :
 */
@Dao
internal interface CollectDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCollect(collect : CollectEntity)

    @Query("SELECT * FROM collects")
    fun getCollects() : DataSource.Factory<Int,CollectEntity>

    @Delete
    suspend fun removeCollect(collect: CollectEntity)

//    @Query("")
//    fun emptyCollect() : LiveData<Boolean>

}