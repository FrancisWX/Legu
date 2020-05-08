package com.wx.library_common.extension

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

/**
 *Created by wx on 20-4-19
 *Description :
 */


fun ViewModel.requestFromIo(work : suspend() -> Unit) {
    viewModelScope.launch(Dispatchers.IO) {
        work.invoke()
    }
}