package com.example.shoppinglist.damain

class AddShopItemUseCase(private var shopIListRepository: ShopIListRepository) {
    fun addShopItem(shopItem: ShopItem) {
        shopIListRepository.addShopItem(shopItem)

    }
}