package com.example.hellokotlin.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import com.example.hellokotlin.R

class IndividualViewActivity : AppCompatActivity() {

    var actModel: ActionMode.Callback? = null
    var actionMode: ActionMode? = null
    lateinit var btn: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_individual_view)
        init()
        initView()
        initListener()
    }

    private fun initView() {
        btn = findViewById(R.id.btn_show_menus)
    }

    private fun init() {
        actModel = object : ActionMode.Callback {
            override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                return when (item?.itemId) {
                    R.id.it_android -> {
                        Log.d(TAG, "用户点击了${item.title}")
                        true
                    }
                    R.id.it_ios -> {
                        Log.d(TAG, "用户点击了${item.title}")
                        true
                    }
                    else -> {
                        false
                    }
                }
            }

            override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                menuInflater.inflate(R.menu.context_menu, menu)
                return true
            }

            override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                return false
            }

            override fun onDestroyActionMode(mode: ActionMode?) {
                actModel = null
            }
        }
    }

    private fun initListener() {
        btn.setOnLongClickListener {
            actionMode = startActionMode(actModel)
            true
//            when (actionMode) {
//                null -> {
//                    actionMode = startActionMode(actModel)
//                    true
//                }
//                else -> false
//            }
        }
    }

    companion object {
        private val TAG = "IndividualViewActivity"
    }
}
