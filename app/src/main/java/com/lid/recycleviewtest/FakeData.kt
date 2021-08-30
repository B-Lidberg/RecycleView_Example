package com.lid.recycleviewtest

object FakeData {

    val itemList = listOf(103, 40, 77, 908, 10, 119, 46)

    val sortedList = itemList.sorted().toMutableList()


    fun removeItem(item: Int) {
        sortedList.remove(item)
    }


}