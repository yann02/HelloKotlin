package com.example.hellokotlin.menu.pop

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.PopupMenu
import com.example.hellokotlin.R

class PopMenusActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_menus)
        initView()
    }

    private fun initView() {
        findViewById<Button>(R.id.btn_show_pop_menu).setOnClickListener{
            val viewPopupMenu=PopupMenu(this,it)
            viewPopupMenu.menuInflater.inflate(R.menu.context_menu,viewPopupMenu.menu)
            viewPopupMenu.show()
            viewPopupMenu.setOnDismissListener{
                Log.d(TAG,"点击了菜单外边")
            }
        }
    }

    companion object{
        const val TAG="PopMenusActivity"
    }
}
