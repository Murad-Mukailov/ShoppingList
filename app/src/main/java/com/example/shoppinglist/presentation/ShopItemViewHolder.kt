package com.example.shoppinglist.presentation

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.damain.ShopItem

class ShopItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemClickListener: ((ShopItem) -> Unit)? = null
    val titleName = view.findViewById<TextView>(R.id.title_enabled_text)
    val titleCount = view.findViewById<TextView>(R.id.count_enabled_text)
    private lateinit var currentItem: ShopItem

    init {
        itemView.setOnLongClickListener {
            onShopItemLongClickListener?.invoke(currentItem)
            true
        }

        itemView.setOnClickListener {
            onShopItemClickListener?.invoke(currentItem)
        }
    }

    fun bind(item: ShopItem) {
        currentItem = item
        titleName.text = item.name
        titleCount.text = item.count.toString()
    }
}
