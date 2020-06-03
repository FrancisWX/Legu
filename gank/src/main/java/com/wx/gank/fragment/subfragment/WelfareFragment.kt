package com.wx.gank.fragment.subfragment

import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.scwang.smartrefresh.layout.SmartRefreshLayout
import com.wx.gank.R
import com.wx.lib_base.common.LogUtil
import com.wx.lib_base.view.BaseFragment
import com.wx.gank.adapter.WelfareAdapter
import com.wx.gank.common.GankConstants
import com.wx.gank.viewmodel.WelfareViewModel

/**
 *Created by wx on 19-7-21
 *Description :
 */
class WelfareFragment(val parentFragment : BaseFragment) : BaseFragment() {

    private lateinit var mRecycleView : RecyclerView
    private lateinit var mAdapter: WelfareAdapter
    private lateinit var mRefresher : SmartRefreshLayout

    override fun initBeforeView() {

    }

    override fun getContentId(): Int {
        return R.layout.md_gank_welfare_fragment
    }

    override fun initView() {
        mRefresher = mRootView.findViewById(R.id.refresher_module_gank_welfare_fragment)

        mRecycleView = mRootView.findViewById(R.id.recycler_module_gank_welfare_fragment)

        mRecycleView.layoutManager = GridLayoutManager(mContext, 2)


        mAdapter = WelfareAdapter(mContext)
        mRecycleView.adapter = mAdapter

        mAdapter.mItemClick = fun (pos : Int){
            LogUtil.d("Welfare","pos = $pos")
        }
        mAdapter.mItemLongClick = fun(pos : Int) :  Boolean {
            return false
        }

    }

    override fun initData() {

        val mViewModel by viewModels<WelfareViewModel>({parentFragment})

        mViewModel.getWelfareData().observe(
            this,
            Observer {
                it?.apply {
                    mAdapter.submitList(it)
                    if (it.size <= GankConstants.ITEM_PER_PAGE) {
                        mRefresher.finishRefresh()
                    } else {
                        mRefresher.finishLoadMore()
                    }
                }
            }
        )



        mRefresher.setOnRefreshListener {
            mViewModel.refresh()
        }

        mRefresher.setOnLoadMoreListener {
            mViewModel.loadMore()
        }
    }

}