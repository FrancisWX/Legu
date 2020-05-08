package com.wx.library_common.permissions

/**
 *Created by wx on 20-4-25
 *Description :
 */
sealed class PermissionResult {

    /**
     * 权限允许
     */
    object Grant : PermissionResult()
    /**
     * 权限拒绝
     */
    class Denies(val permissions : Array<String>) : PermissionResult()
    /**
     * 权限拒绝，且下次不再询问
     */
    class DenyAlways(val permissions : Array<String>) : PermissionResult()
}