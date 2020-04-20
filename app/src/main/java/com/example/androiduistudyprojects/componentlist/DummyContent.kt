package com.example.androiduistudyprojects.componentlist

import com.example.androiduistudyprojects.R
import java.util.*

object DummyContent {

    val ITEMS: MutableList<FragmentItem> = ArrayList()

    private val ITEM_MAP: MutableMap<String, FragmentItem> = HashMap()

    init {
        addItem(
            FragmentItem(
                "1",
                "入力項目",
                "input",
                R.id.action_componentFragment_to_blankFragment
            )
        )
        addItem(
            FragmentItem(
                "2",
                "Chips",
                "input",
                R.id.action_componentFragment_to_chipsFragment
            )
        )
        addItem(
            FragmentItem(
                "3",
                "BottomAppBar",
                "",
                null
            )
        )
        addItem(
            FragmentItem(
                "4",
                "Dialog",
                "",
                R.id.action_componentFragment_to_dialogsFragment
            )
        )
        addItem(
            FragmentItem(
                "5",
                "Button",
                "Button",
                R.id.action_componentFragment_to_buttonFragment
            )
        )
    }

    private fun addItem(item: FragmentItem) {
        ITEMS.add(item)
        ITEM_MAP[item.id] = item
    }
}

data class FragmentItem(
    val id: String,
    val content: String,
    val details: String,
    val actionId: Int?
) {
    override fun toString(): String = content
}