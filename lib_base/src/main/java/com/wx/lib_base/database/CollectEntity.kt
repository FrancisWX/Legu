package com.wx.library_common.database

import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull

/**
 *Created by wx on 19-9-2
 *Description :
 */
@Entity(tableName = "collects")
data class CollectEntity(
    @PrimaryKey
    @NotNull
    val id : String,
    val title : String,
    val author : String,
    val url : String,
    val date : String
) {
    override fun toString(): String {
        return "[ id = $id, title = $title, author = $author]"
    }
}