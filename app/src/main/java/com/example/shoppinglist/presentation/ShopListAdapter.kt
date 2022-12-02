package com.example.shoppinglist.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.damain.ShopItem

class ShopListAdapter :
    ListAdapter<ShopItem, ShopListAdapter.ShopItemViewHolder>(ShopItemDiffCallback()) {
    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemClickListener: ((ShopItem) -> Unit)? = null

    override fun getItemViewType(position: Int): Int {
        val item = getItem(position)
        return if (item.enabled) {
            R.layout.item_shop_enabled
        } else {
            R.layout.item_shop_disabled
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopItemViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(viewType, parent, false)
        return ShopItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ShopItemViewHolder, position: Int) {
        val shopItem = getItem(position)
        holder.bind(shopItem)
    }

    inner class ShopItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
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

    companion object {
        const val MAX_POOL_SIZE = 25
    }
}