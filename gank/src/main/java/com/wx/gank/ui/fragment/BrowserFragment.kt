package com.wx.gank.ui.fragment

import android.graphics.Bitmap
import android.view.View
import android.widget.ProgressBar
import com.alibaba.android.arouter.facade.annotation.Route
import com.tencent.smtt.sdk.WebChromeClient
import com.tencent.smtt.sdk.WebView
import com.tencent.smtt.sdk.WebViewClient
import com.wx.gank.R
import com.wx.gank.common.GankConstants
import com.wx.lib_base.common.LogUtil
import com.wx.lib_base.view.BaseActivity
import com.wx.lib_base.view.BaseFragment
import com.wx.lib_base.view.X5WebView

/**
 * @author wx
 */
@Route(path = GankConstants.BROWSER_PATH)
class BrowserFragment : BaseFragment() {

    private lateinit var mWebView: X5WebView
    private lateinit var mProgress: ProgressBar

    override fun initBeforeView() {
        LogUtil.d("initBrowser")
    }

    override fun getContentId(): Int = R.layout.md_gank_browser_fragment

    override fun initView() {
        mProgress = mRootView.findViewById(R.id.progress_gank_browser_fragment)
        mWebView = mRootView.findViewById(R.id.webview_gank_browser_fragment)

        mWebView.run {
            webViewClient = object : WebViewClient() {
                override fun onPageStarted(p0: WebView?, p1: String?, p2: Bitmap?) {
                    super.onPageStarted(p0, p1, p2)
                    mProgress.visibility = View.VISIBLE
                }

                override fun onPageFinished(p0: WebView?, p1: String?) {
                    super.onPageFinished(p0, p1)
                    mProgress.visibility = View.GONE
                }
            }
            webChromeClient = object : WebChromeClient() {
                override fun onProgressChanged(p0: WebView?, p1: Int) {
                    super.onProgressChanged(p0, p1)
                    mProgress.progress = p1
                }
            }
        }
    }

    override fun initData() {
        arguments?.getString(GankConstants.URL_BROWSER, "")?.let {  url ->
            url.isNotEmpty().apply {
                LogUtil.d("url = $url")
                mWebView.loadUrl(url)
            }
        }
    }


}