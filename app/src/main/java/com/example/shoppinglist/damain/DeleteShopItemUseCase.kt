package com.example.shoppinglist.damain

class DeleteShopItemUseCase(private var shopIListRepository: ShopIListRepository) {

    fun deleteShopItem(shopItem: ShopItem){
        shopIListRepository.deleteShopItem(shopItem)

    }
}