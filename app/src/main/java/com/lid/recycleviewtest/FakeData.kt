package com.lid.recycleviewtest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class FakeData {

    private val itemList = listOf(103, 40, 77, 908, 10, 119, 46)

    private val sortedListLiveData = MutableLiveData(itemList.sorted())

    fun getItemList(): LiveData<List<Int>> = sortedListLiveData


    fun removeItem(item: Int) {
        val currentList =  sortedListLiveData.value

        if (currentList != null) {
            val updatedList = currentList.toMutableList()
            updatedList.remove(item)
            sortedListLiveData.postValue(updatedList)
        }
    }


}