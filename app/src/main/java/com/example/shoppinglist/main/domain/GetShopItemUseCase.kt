package com.example.shoppinglist.main.domain

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {
    fun getShopItem(shopItem: Int): ShopItem {
        return shopListRepository.getShopItem(shopItem)

    }
}