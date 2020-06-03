package com.wx.gank.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.wx.lib_base.view.BaseFragment

/**
 *Created by wx on 19-7-28
 *Description :
 */
class ViewPagerAdapter(val fragment : BaseFragment,val fragments : MutableList<BaseFragment>) : FragmentStateAdapter(fragment){


    override fun getItemCount(): Int  = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

}