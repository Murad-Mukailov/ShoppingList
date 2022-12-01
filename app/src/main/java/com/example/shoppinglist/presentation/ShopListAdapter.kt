package com.example.shoppinglist.presentation

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.shoppinglist.R
import com.example.shoppinglist.damain.ShopItem
import java.lang.RuntimeException

class ShopListAdapter : RecyclerView.Adapter<ShopListAdapter.ShopItemViewHolder>() {
    var count = 0
    var onShopItemLongClickListener: ((ShopItem) -> Unit)? = null
    var onShopItemClickListener: ((ShopItem) -> Unit)? = null

    var shopList = listOf<ShopItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemViewType(position: Int): Int {
        val item = shopList[position]
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
        val shopItem = shopList[position]
        holder.bind(shopItem)
    }


    override fun getItemCount(): Int {
        return shopList.size
    }


//    override fun onViewRecycled(holder: ShopItemViewHolder) {
//        super.onViewRecycled(holder)
//        holder.titleName.text = " "
//        holder.titleCount.text = " "
//        holder.titleName.setTextColor(
//            ContextCompat.getColor(
//                holder.itemView.context,
//                R.color.white
//            )
//        )
//    }

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

    interface OnShopItemLongClickListener {
        fun onShopLogItemClick(shopItem: ShopItem)
    }

    companion object {
        const val MAX_POOL_SIZE = 25
    }
}