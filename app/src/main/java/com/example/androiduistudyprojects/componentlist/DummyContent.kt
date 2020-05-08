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
        addItem(
            FragmentItem(
                "6",
                "Menu",
                "Menu",
                R.id.action_componentFragment_to_menusActivity
            )
        )
        addItem(
            FragmentItem(
                "7",
                "Drawer",
                "Drawer",
                null
            )
        )
        addItem(
            FragmentItem(
                "8",
                "Scrolling",
                "Scrolling",
                null
            )
        )
        addItem(
            FragmentItem(
                "9",
                "Book",
                "Book",
                null
            )
        )
        addItem(
            FragmentItem(
                "10",
                "Card",
                "Card",
                R.id.action_componentFragment_to_cardFragment
            )
        )
        addItem(
            FragmentItem(
                "11",
                "Drawable",
                "Drawable",
                R.id.action_componentFragment_to_drawableFragment
            )
        )
        addItem(
            FragmentItem(
                "12",
                "Gesture",
                "Gesture",
                R.id.action_componentFragment_to_gestureFragment
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