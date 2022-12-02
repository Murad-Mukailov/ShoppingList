package com.example.shoppinglist.damain

class EditShopItemUseCase(private val shopIListRepository: ShopIListRepository) {

    fun editShopItem(shopItem: ShopItem){
        shopIListRepository.editShopItem(shopItem)
    }
}