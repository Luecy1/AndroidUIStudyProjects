package com.example.androiduistudyprojects.dialogs

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class DialogsViewModel @Inject constructor() : ViewModel() {

    val dialogFlg1: LiveData<Boolean>
        get() = _dialogFlg1

    private val _dialogFlg1 = MutableLiveData<Boolean>()

    fun onClickButton1() {
        _dialogFlg1.value = true
    }

    fun onCloseDialog1() {
        _dialogFlg1.value = false
    }
}