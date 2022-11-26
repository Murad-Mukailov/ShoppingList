package com.example.shoppinglist.damain

class GetShopItemUseCase(private val shopIListRepository: ShopIListRepository) {

    fun getShopItem(shopItemId: ShopItem): ShopItem {
       return shopIListRepository.getShopItem(shopItemId)
    }
}