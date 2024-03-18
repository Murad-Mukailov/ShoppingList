package com.example.shoppinglist.main.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.shoppinglist.R
import com.example.shoppinglist.main.domain.ShopItem

class ShopListAdapter : ListAdapter <ShopItem, ShopItemViewHolder>(ShopItemDiffCallback()) {

    var onShopItemLongClick: ((ShopItem) -> Unit)? = null
    var onShopItemClick: ((ShopItem) -> Unit)? = null
    var onShopItemDeleteClick: ((ShopItem) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {
        val layout = when (viewType) {
            ENABLED_TYPE -> R.layout.item_shop_enabled
            DISABLED_TYPE -> R.layout.item_shop_disabled
            else -> throw Exception("Unknown view type ${viewType}")
        }
        val view = LayoutInflater.from(parent.context)
            .inflate(layout, parent, false)
        return ShopItemViewHolder(view)
    }
    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val shopItem = getItem(position)
        holder.tvName.text = shopItem.name
        holder.tvCount.text = shopItem.count.toString()
        holder.itemView.setOnLongClickListener {
            onShopItemLongClick?.invoke(shopItem)
            true
        }
        holder.itemView.setOnClickListener {
            onShopItemClick?.invoke(shopItem)
        }
    }


    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.enabled) {
            ENABLED_TYPE
        } else {
            DISABLED_TYPE
        }
    }

    companion object {
        const val ENABLED_TYPE = 1
        const val DISABLED_TYPE = 0
        const val POOL_SIZE = 20
    }
}