package com.example.lab01.model

import com.example.lab01.R

class MyData : ItemManager {

    private val items = listOf(
        Item.BigItem(
            "Subhead", "description", "1", 1, R.drawable.media,
            R.drawable.avatar, "Header", "Subhead", "Title"
        ),
        Item.SmallItem(
            "3", 0, R.drawable.media_low,
            R.drawable.avatar, "Header", "Subhead", "Title"
        ),
        Item.BigItem(
            "Subhead", "description", "2", 1, R.drawable.media,
            R.drawable.avatar, "Header", "Subhead", "Title"
        ),
        Item.BigItem(
            "Subhead", "description", "4", 1, R.drawable.media,
            R.drawable.avatar, "Header", "Subhead", "Title"
        ),
        Item.SmallItem(
            "5", 0, R.drawable.media_low,
            R.drawable.avatar, "Header", "Subhead", "Title"
        ),
    )

    override fun getItems(): List<Item> {
        return this.items
    }

    override fun getItem(id: String): Item? {
        return this.items.find { it.id == id }
    }
}