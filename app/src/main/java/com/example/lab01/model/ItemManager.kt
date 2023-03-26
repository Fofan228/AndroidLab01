package com.example.lab01.model

interface ItemManager {
    public fun getItems(): List<Item>
    public fun getItem(id: String): Item?
}