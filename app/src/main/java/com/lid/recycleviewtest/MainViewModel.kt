package com.lid.recycleviewtest

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider


class MainViewModel(val data: FakeData) : ViewModel() {

    val itemList = data.getItemList()

    fun removeItem(item: Int) {
        data.removeItem(item)
    }
}

class MainViewModelFactory() : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return MainViewModel(
                data = FakeData()
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}