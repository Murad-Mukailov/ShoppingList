package com.example.shoppinglist.damain

import androidx.lifecycle.LiveData

class GetShopListUseCase(private val shopIListRepository: ShopIListRepository) {
    fun getShopList(): LiveData<List<ShopItem>> {
       return shopIListRepository.getShopList()

    }
}