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
class AndroidFragment (private val parentFragment : BaseFragment): BaseFragment(){

    private val TAG : String = this.javaClass.simpleName

    private lateinit var mRefresher : SmartRefreshLayout
    private lateinit var mRecycleView : RecyclerView
    private lateinit var mAdapter: GankDataAdapter

    override fun initBeforeView() {

    }

    override fun getContentId(): Int {
        return R.layout.md_gank_android_fragment
    }

    override fun initView() {
        mRecycleView = mRootView.findViewById(R.id.recycler_module_gank_android_fragment)
        val layoutManager = LinearLayoutManager(mContext)

        mRecycleView.layoutManager = layoutManager

        val itemDecoration = DividerItemDecoration(mRecycleView.context,layoutManager.orientation)
        mContext.getDrawable(R.drawable.bg_item_decoration_recycler_viewer)?.let {
            itemDecoration.setDrawable(it)
        }
        mRecycleView.addItemDecoration(itemDecoration)

        mAdapter = GankDataAdapter(mContext)
        mRecycleView.adapter = mAdapter

        mRefresher = mRootView.findViewById(R.id.refresh_module_gank_android_fragment)


    }

    override fun initData() {

        val mViewModel by viewModels<GankViewModel>({parentFragment})

        mViewModel.getAndroidData().observe(
            this,
            Observer {data ->
                data?.let{
                    mAdapter.submitList(it)
                    if (it.size > GankConstants.ITEM_PER_PAGE) {
                        mRefresher.finishLoadMore()
                    } else {
                        mRefresher.finishRefresh()
                    }
                }
            }
        )

        mRefresher.setOnRefreshListener {
            mViewModel.refresh(GankConstants.ANDROID_CONTENT_TYPE)
        }
        mRefresher.setOnLoadMoreListener {
            mViewModel.loadMore(GankConstants.ANDROID_CONTENT_TYPE)
        }

    }

}