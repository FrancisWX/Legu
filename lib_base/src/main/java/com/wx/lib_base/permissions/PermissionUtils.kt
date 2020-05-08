package com.wx.library_common.permissions

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.MutableLiveData
/**
 *Created by wx on 20-4-25
 *Description :
 */
class PermissionUtils {

    companion object {
        private const val FRAGMENT_TAG = "PermissionHolderFragment"
    }
    @Volatile
    private var mHolderFragment : HolderFragment? = null

    constructor(fragment : Fragment) {
        mHolderFragment = initHolderFragment(fragment.childFragmentManager)
    }

    constructor(activity : AppCompatActivity) {
        mHolderFragment = initHolderFragment(activity.supportFragmentManager)
    }

    private fun initHolderFragment(manager : FragmentManager) =
        mHolderFragment ?: synchronized(this) {
            mHolderFragment ?: if (manager.findFragmentByTag(FRAGMENT_TAG) == null) HolderFragment().run {
                manager.beginTransaction().add(this, FRAGMENT_TAG).commitNow()
                this
            } else manager.findFragmentByTag(FRAGMENT_TAG) as HolderFragment
        }



    fun requestPermission(vararg  permissions : String) : MutableLiveData<PermissionResult> = request(permissions)

    private fun request(permissions : Array<out String>) : MutableLiveData<PermissionResult> {
        mHolderFragment!!.requestPermissions(permissions)
        return mHolderFragment!!.result
    }


}