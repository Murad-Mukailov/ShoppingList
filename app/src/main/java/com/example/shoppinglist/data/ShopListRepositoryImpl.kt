package com.example.shoppinglist.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.shoppinglist.damain.ShopIListRepository
import com.example.shoppinglist.damain.ShopItem
import java.lang.RuntimeException
import kotlin.random.Random

object ShopListRepositoryImpl : ShopIListRepository {

    private val shopList = sortedSetOf<ShopItem>({o1,o2 -> o1.id.compareTo(o2.id)})
    private var shopListLD = MutableLiveData<List<ShopItem>>()
    private var autoIncrementID = 0

    override fun addShopItem(shopItem: ShopItem) {
        if (shopItem.id == ShopItem.UNDEFINED_ID) {
            shopItem.id = autoIncrementID++
        }
        shopList.add(shopItem)
        updateList()

    }

    override fun deleteShopItem(shopItem: ShopItem) {
        shopList.remove(shopItem)
        updateList()
    }

    override fun editShopItem(shopItem: ShopItem) {
        val oldItem = getShopItem(shopItem.id)
        shopList.remove(oldItem)
        shopList.add(shopItem)
        updateList()
    }


    override fun getShopItem(shopItemId: Int): ShopItem {
        return shopList.find {
            it.id == shopItemId
        } ?: throw RuntimeException("Element with id $shopItemId not found")
    }

    override fun getShopList():LiveData<List<ShopItem>> {
        return shopListLD
    }

    private fun updateList(){
        shopListLD.value = shopList.toList()

    }

    init {
        for (i in 0 until 100){
            val item = ShopItem("Name $i ", i,Random.nextBoolean())
            addShopItem(item)
        }
    }
}