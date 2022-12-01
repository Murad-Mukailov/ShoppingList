package com.example.shoppinglist.damain

class GetShopItemUseCase(private val shopIListRepository: ShopIListRepository) {

    fun getShopItem(shopItemId: Int): ShopItem {
       return shopIListRepository.getShopItem(shopItemId)
    }
}