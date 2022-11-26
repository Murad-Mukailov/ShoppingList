package com.example.shoppinglist.damain

interface ShopIListRepository {
    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

    fun editShopItem(shopItem: ShopItem)

    fun getShopItem(shopItemId: ShopItem):ShopItem

    fun getShopList(): List<ShopItem>

}