package com.example.shoppinglist.main.presentation

import androidx.lifecycle.ViewModel
import com.example.shoppinglist.main.data.ShopListRepositoryImpl
import com.example.shoppinglist.main.domain.DeleteShopItemUseCase
import com.example.shoppinglist.main.domain.EditShopItemUseCase
import com.example.shoppinglist.main.domain.GetShopListUseCase
import com.example.shoppinglist.main.domain.ShopItem

class MainViewModel:ViewModel() {

    private val repository = ShopListRepositoryImpl
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()
    fun deleteShopItem(shopItem: ShopItem){
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnabledState(shopItem: ShopItem){
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}