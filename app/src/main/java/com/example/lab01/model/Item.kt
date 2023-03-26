package com.example.lab01.model

sealed class Item(
    open val id: String,
    open val viewType: Int,
    open val image: Int,
    open val avatar: Int,
    open val header: String,
    open val subhead: String,
    open val title: String
) {

    data class BigItem(
        val titleSubhead: String,
        val description: String,

        override val id: String,
        override val viewType: Int,
        override val image: Int,
        override val avatar: Int,
        override val header: String,
        override val subhead: String,
        override val title: String
    ) : Item(id, viewType, image, avatar, header, subhead, title)

    data class SmallItem(
        override val id: String,
        override val viewType: Int,
        override val image: Int,
        override val avatar: Int,
        override val header: String,
        override val subhead: String,
        override val title: String
    ) : Item(id, viewType, image, avatar, header, subhead, title)
}