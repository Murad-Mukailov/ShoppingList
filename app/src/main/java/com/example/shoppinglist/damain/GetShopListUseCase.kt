package com.example.shoppinglist.damain

class GetShopListUseCase(private val shopIListRepository: ShopIListRepository) {
    fun getShopList(): List<ShopItem> {
       return shopIListRepository.getShopList()

    }
}