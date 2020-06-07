package com.wx.gank.ui.fragment

import android.graphics.Color
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import com.to.aboomy.pager2banner.Banner
import com.to.aboomy.pager2banner.IndicatorView
import com.wx.gank.R
import com.wx.lib_base.view.BaseFragment
import com.wx.gank.adapter.BannerAdapter
import com.wx.gank.adapter.ViewPagerAdapter
import com.wx.gank.common.GankConstants
import com.wx.gank.ui.fragment.subfragment.*
import com.wx.gank.viewmodel.GankViewModel

/**
 *Created by wx on 19-7-14
 *Description :
 */
class GankFragment : BaseFragment(){

    private val TAG : String = "GankFragment"
    private lateinit var mCoverImg : ImageView

    private lateinit var mTabLayout : TabLayout
    private lateinit var mViewPager2: ViewPager2
    private lateinit var mViewPagerAdapter: ViewPagerAdapter

    private lateinit var mBanner : Banner
    private lateinit var mBannerAdapter: BannerAdapter


    override fun initBeforeView() {
    }

    override fun getContentId(): Int {
        return R.layout.md_gank_main_fragment
    }

    override fun initView() {
        mTabLayout = mRootView.findViewById(R.id.layout_tab_module_gank_main_fragment)
        mViewPager2 = mRootView.findViewById(R.id.vp2_pager_module_gank_main_fragment)
//        mCoverImg = mRootView.findViewById(R.id.iv_cover_module_gank_main_fragment)
        mBanner = mRootView.findViewById(R.id.banner_view_md_gank_main_fragment)
    }

    override fun initData() {

//        PermissionUtils(this).requestPermission(
//            "android.permission.INTERNET"
//        ).observe(this, Observer { result ->
//            when (result) {
//                is PermissionResult.Grant -> {
//                    LogUtil.d("Permission Granted >>>")
//                }
//                is PermissionResult.Denies -> {
//                    result.permissions.forEach {
//                        LogUtil.d("deny : $it")
//                    }
//                }
//                is PermissionResult.DenyAlways -> {
//                    result.permissions.forEach {
//                        LogUtil.d("denyAlways : $it")
//                    }
//                }
//            }
//        })


        val mGankViewModel by viewModels<GankViewModel>()

        val title = mutableListOf(
            getString(R.string.title_android_content),
            getString(R.string.title_ios_content),
            getString(R.string.title_frontend_content),
            getString(R.string.title_flutter_content),
            getString(R.string.title_welfare_content)
        )
        val fragments = mutableListOf(
            AndroidFragment(this),
            IOSFragment(this),
            WebFragment(this),
            FlutterFragment(this),
            WelfareFragment(this)
        )

        mViewPagerAdapter = ViewPagerAdapter(this,fragments)
        mViewPager2.adapter = mViewPagerAdapter

        TabLayoutMediator(mTabLayout,mViewPager2){ tab, position ->
            tab.text = title[position]
        }.attach()

        mBannerAdapter = BannerAdapter(mContext)

        mBanner.setIndicator(
            IndicatorView(mContext).setIndicatorColor(Color.DKGRAY)
                .setIndicatorSelectorColor(Color.WHITE)
        ).adapter = mBannerAdapter

        mGankViewModel.getBannerDatas().observe(this, Observer {
            it?.apply {
                mBannerAdapter.submitList(it.data)
            }
        })

    }

}