package com.wx.gank.fragment.subfragment

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.wx.gank.R
import com.wx.lib_base.view.BaseFragment
import com.wx.gank.adapter.GankDataAdapter
import com.wx.gank.common.GankConstants
import com.wx.gank.viewmodel.GankViewModel

/**
 *Created by wx on 19-7-21
 *Description :
 */
class WebFragment (val parentFragment : BaseFragment): BaseFragment(){

    private lateinit var mRecycleView : RecyclerView
    private lateinit var mAdapter: GankDataAdapter
    private lateinit var mRefresher : SmartRefreshLayout

    override fun initBeforeView() {
    }

    override fun getContentId(): Int {
        return R.layout.md_gank_web_fragment
    }

    override fun initView() {
        mRecycleView = mRootView.findViewById(R.id.recycler_module_gank_web_fragment)
        val layoutManager = LinearLayoutManager(mContext)

        mRecycleView.layoutManager = layoutManager

        val itemDecoration = DividerItemDecoration(mRecycleView.context,layoutManager.orientation)
        mContext.getDrawable(R.drawable.bg_item_decoration_recycler_viewer)?.let {
            itemDecoration.setDrawable(it)
        }
        mRecycleView.addItemDecoration(itemDecoration)

        mAdapter = GankDataAdapter(mContext)
        mRecycleView.adapter = mAdapter

        mRefresher = mRootView.findViewById(R.id.refresher_module_gank_web_fragment)
    }

    override fun initData() {
        val mViewModel by viewModels<GankViewModel>({parentFragment})

        mViewModel.getWebData(GankConstants.NUM_START_PAGE).observe(
            this,
            Observer {
                mAdapter.submitList(it)
                if (it.size > GankConstants.ITEM_PER_PAGE) {
                    mRefresher.finishLoadMore()
                } else {
                    mRefresher.finishRefresh()
                }
            }
        )

        mRefresher.setOnRefreshListener {
            mViewModel.refresh(GankConstants.WEB_CONTENT_TYPE)
        }
        mRefresher.setOnLoadMoreListener {
            mViewModel.loadMore(GankConstants.WEB_CONTENT_TYPE)
        }
    }

}