package com.example.androiduistudyprojects.componentlist.dummy

import java.util.*

object DummyContent {

    val ITEMS: MutableList<FragmentItem> = ArrayList()

    private val ITEM_MAP: MutableMap<String, FragmentItem> = HashMap()

    init {
        addItem(FragmentItem("1", "入力項目", "input"))
    }

    private fun addItem(item: FragmentItem) {
        ITEMS.add(item)
        ITEM_MAP[item.id] = item
    }
}

data class FragmentItem(val id: String, val content: String, val details: String) {
    override fun toString(): String = content
}