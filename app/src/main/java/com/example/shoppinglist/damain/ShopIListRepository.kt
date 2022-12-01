package com.example.shoppinglist.damain

import androidx.lifecycle.LiveData

interface ShopIListRepository {
    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItem(shopItemId: Int):ShopItem

    fun getShopList(): LiveData<List<ShopItem>>

}