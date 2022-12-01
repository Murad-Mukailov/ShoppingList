package com.example.shoppinglist.presentation

import android.content.Context
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.ItemTouchHelper
import com.example.shoppinglist.R
import com.example.shoppinglist.damain.DeleteShopItemUseCase
import com.example.shoppinglist.damain.EditShopItemUseCase
import com.example.shoppinglist.damain.GetShopListUseCase
import com.example.shoppinglist.damain.ShopItem
import com.example.shoppinglist.data.ShopListRepositoryImpl

class MainViewModel : ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val getShopListUseCase = GetShopListUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)

    val shopLIst = getShopListUseCase.getShopList()

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun changeEnableState(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }

}