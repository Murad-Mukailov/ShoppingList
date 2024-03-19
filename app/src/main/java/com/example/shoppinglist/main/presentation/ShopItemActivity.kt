package com.example.shoppinglist.main.presentation

import android.content.Context
import android.content.Intent
import com.example.shoppinglist.R
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

class ShopItemActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shop_item)
        val mode = intent.getStringExtra(EXTRA_SCREEN_MODE)
        Log.d("ShopItemActivity","ddddddddd")
    }
    companion object {
        private const val EXTRA_SCREEN_MODE = "extra_mode"
        private const val EXTRA_SHOP_ITEM_ID = "extra_shop_item_id"
        private const val EXTRA_ADD = "extra_add"
        private const val EXTRA_EDIT = "extra_edit"
        fun newIntentAddItem(context: Context): Intent {
            val intent = Intent(context, ShopItemActivity::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE, EXTRA_ADD)
            return intent
        }
        fun newIntentEditItem(context: Context, shopItemID: Int): Intent {
            val intent = Intent(context, ShopItemActivity::class.java)
            intent.putExtra(EXTRA_SCREEN_MODE, EXTRA_EDIT)
            intent.putExtra(EXTRA_SHOP_ITEM_ID, shopItemID)
            return intent
        }
    }
}