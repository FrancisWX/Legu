package com.wx.library_common.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 *Created by wx on 19-7-21
 *Description :
 */

open class BaseViewModel : ViewModel(){



    fun requestFromIO(
        work : suspend () -> Unit
    ) {
        viewModelScope.launch(Dispatchers.IO){
            work.invoke()
        }
    }
}