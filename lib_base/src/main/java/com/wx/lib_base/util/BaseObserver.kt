package com.wx.library_common.util

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import com.wx.library_common.view.BaseActivity

/**
 *Created by wx on 19-7-14
 *Description :
 */
abstract class BaseActivityObserver (protected val customActivity: BaseActivity) : LifecycleObserver {
    //比如要判断MainActivity是否在onResumed状态，可以这样判断：
    //if(activity.getLifecycle().getCurrentState() == Lifecycle.State.RESUMED);
    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    protected fun onCreate(){}

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    protected fun onStart(){}

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    protected fun onResume(){}

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    protected fun onPause(){}

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    protected fun onStop(){}

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    protected fun onDestroy(){}

}