package com.wx.library_common.permissions

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.lifecycle.MutableLiveData
import java.util.*

/**
 *Created by wx on 20-4-25
 *Description :
 */
class HolderFragment : Fragment() {

    private val PERMISSION_REQUEST_CODE = 100

    lateinit var result : MutableLiveData<PermissionResult>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    fun requestPermissions(permissions: Array<out String>) {
        result = MutableLiveData()
        requestPermissions(permissions, PERMISSION_REQUEST_CODE)
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode == PERMISSION_REQUEST_CODE) {
            val denies = ArrayList<String>()
            val denyAlways = ArrayList<String>()

            for ((index, value) in grantResults.withIndex()) {
                if (value == PackageManager.PERMISSION_DENIED) {
                    permissions[index].apply {
                        if (shouldShowRequestPermissionRationale(this)) {
                            denies.add(this)
                        } else {
                            denyAlways.add(this)
                        }
                    }
                }
            }

            if (denies.isEmpty() and denyAlways.isEmpty()) {
                result.value = PermissionResult.Grant
            } else {
                if (denyAlways.isNotEmpty()) {
                    result.value = PermissionResult.DenyAlways(denyAlways.toTypedArray())
                } else if (denies.isNotEmpty()) {
                    result.value = PermissionResult.Denies(denies.toTypedArray())
                }
            }
        }
    }
}