package com.example.shoppinglist.main.domain

import androidx.lifecycle.LiveData

interface ShopListRepository {
    fun addShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItem(shopItem: Int): ShopItem

    fun deleteShopItem(shopItem: ShopItem)

    fun getShopList() : LiveData <List<ShopItem>>
}