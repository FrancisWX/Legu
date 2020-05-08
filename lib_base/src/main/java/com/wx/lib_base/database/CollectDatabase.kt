package com.wx.library_common.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.wx.library_common.common.Constants

/**
 *Created by wx on 19-9-2
 *Description :
 */

@Database( entities = [CollectEntity::class], version = Constants.COLLECT_DATABASE_VERSION,exportSchema = false)
internal abstract class CollectDatabase  : RoomDatabase(){

    companion object {
        @Volatile private var INSTANCE : CollectDatabase? = null

        fun getInstance(context: Context) : CollectDatabase = INSTANCE ?: buildDatabase(context).also{ INSTANCE = it }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context.applicationContext,CollectDatabase::class.java,Constants.COLLECT_DATABASE_NAME)
//            .addMigrations(MIGRATIONS_1_2)
            .build()

        private val MIGRATIONS_1_2 = Migration1to2()

    }

    abstract fun collectDao() : CollectDao

    class Migration1to2 : Migration(1,2){
        override fun migrate(database: SupportSQLiteDatabase) {

        }
    }
}