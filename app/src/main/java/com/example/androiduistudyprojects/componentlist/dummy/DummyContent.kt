package com.example.androiduistudyprojects.componentlist.dummy

import java.util.*

object DummyContent {

    val ITEMS: MutableList<FragmentItem> = ArrayList()

    private val ITEM_MAP: MutableMap<String, FragmentItem> = HashMap()

    private const val COUNT = 25

    init {
        for (i in 1..COUNT) {
            addItem(createDummyItem(i))
        }

        addItem(FragmentItem("1", "Input", "input"))
    }

    private fun addItem(item: FragmentItem) {
        ITEMS.add(item)
        ITEM_MAP[item.id] = item
    }

    private fun createDummyItem(position: Int): FragmentItem {
        return FragmentItem(position.toString(), "Item $position", makeDetails(position))
    }

    private fun makeDetails(position: Int): String {
        val builder = StringBuilder()
        builder.append("Details about Item: ").append(position)
        for (i in 0 until position) {
            builder.append("\nMore details information here.")
        }
        return builder.toString()
    }
}

data class FragmentItem(val id: String, val content: String, val details: String) {
    override fun toString(): String = content
}