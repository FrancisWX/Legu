package com.wx.lib_base.util

import android.content.Context
import android.content.SharedPreferences
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 *Created by wx on 19-7-14
 *Description :
 */
class PreferenceUtils<T>(private val context: Context,private val table: String, private val key: String, private val default: T) :
    ReadWriteProperty<Any, T> {

    private val preference: SharedPreferences by lazy {
        context.getSharedPreferences(table, Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any, property: KProperty<*>): T {
        return getValueByKey(key, default)
    }

    override fun setValue(thisRef: Any, property: KProperty<*>, value: T) {
        setValueByKey(key, value)
    }

    /**
     * 根据Key获取值
     */
    @Suppress("UNCHECKED_CAST")
    private fun getValueByKey(key: String, default: T): T = with(preference) {
        val value: Any = when (default) {
            is Boolean -> getBoolean(key, default)
            is Int -> getInt(key, default)
            is Long -> getLong(key, default)
            is Float -> getFloat(key, default)
            is String -> getString(key, default)
            else -> getString(key, default.toString())
        }
        return value as T
    }

    /**
     * 设置值
     */
    private fun setValueByKey(key: String, value: T) = with(preference.edit()) {
        when (value) {
            is Boolean -> putBoolean(key, value)
            is Int -> putInt(key, value)
            is String -> putString(key, value)
            is Long -> putLong(key, value)
            is Float -> putFloat(key, value)
            else -> putString(key, value.toString())
        }.apply()
    }

    /**
     * 清空数据
     */
    fun clearPreferences() {
        preference.edit().clear().apply()
    }

    /**
     * 删除数据
     */
    fun deletePreferenceByKey(key: String): Boolean {
        preference.edit().remove(key).apply()
        return preference.contains(key)
    }

    /**
     * 是否含有该key
     */
    fun containKey(key: String): Boolean {
        return preference.contains(key)
    }

}