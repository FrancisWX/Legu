package com.wx.wanandroid.fragment.subfragment

import android.graphics.Color
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.to.aboomy.pager2banner.Banner
import com.to.aboomy.pager2banner.IndicatorView
import com.wx.lib_base.view.BaseFragment
import com.wx.module_wanandroid.R
import com.wx.module_wanandroid.adapter.ArticleAdapter
import com.wx.module_wanandroid.adapter.BannerAdapter
import com.wx.module_wanandroid.viewmodel.HomeViewModel

/**
 *Created by wx on 20-3-15
 *Description : 首页界面
 */
class HomeFragment : BaseFragment() {

    private lateinit var mToolbar: Toolbar
    private lateinit var mBanner: Banner
    private lateinit var mBannerAdapter: BannerAdapter
    private lateinit var mRefreshLayout: SwipeRefreshLayout
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mArticleAdapter: ArticleAdapter

    override fun initBeforeView() {
    }

    override fun getContentId(): Int = R.layout.md_wanandroid_home_fragment

    override fun initView() {
        mToolbar = mRootView.findViewById(R.id.toolbar_view_fragment_home_module_wanandroid)

        mBanner = mRootView.findViewById(R.id.banner_view_fragment_home_module_wanandroid)
        mRefreshLayout = mRootView.findViewById(R.id.refresh_layout_fragment_home_module_wanandroid)
        mRecyclerView = mRootView.findViewById(R.id.recycler_layout_fragment_home_module_wanandroid)

        mBannerAdapter = BannerAdapter(mContext)

        mBanner.setIndicator(
            IndicatorView(mContext).setIndicatorColor(Color.DKGRAY)
                .setIndicatorSelectorColor(Color.WHITE)
        ).adapter = mBannerAdapter

        mArticleAdapter = ArticleAdapter(mContext)
        mRecyclerView.layoutManager = LinearLayoutManager(mContext)
        mRecyclerView.adapter = mArticleAdapter
    }

    override fun initData() {

        val mViewModel by viewModels<HomeViewModel>()

        mViewModel.getBannerDatas().observe(viewLifecycleOwner, Observer {
            it?.apply {
                mBannerAdapter.submitList(it)
            }
        })

        mViewModel.getHomeArticleDatas().observe(viewLifecycleOwner, Observer {
            it?.apply {
                mArticleAdapter.submitList(it.datas)
            }
        })


    }

}
