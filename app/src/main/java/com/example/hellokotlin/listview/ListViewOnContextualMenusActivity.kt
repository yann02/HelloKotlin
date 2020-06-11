package com.example.hellokotlin.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.AbsListView
import android.widget.ListView
import com.example.hellokotlin.R

class ListViewOnContextualMenusActivity : AppCompatActivity() {

    private lateinit var data: Array<String>
    private lateinit var lv: ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view_on_contextual_menus)
        initDatas()
        initViews()
    }

    private fun initViews() {
        lv = findViewById(R.id.lv_main)
        lv.adapter = ListViewAdapter(data, this)
        with(lv) {
            choiceMode = ListView.CHOICE_MODE_MULTIPLE_MODAL
            setMultiChoiceModeListener(object : AbsListView.MultiChoiceModeListener {
                override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
                    return when (item?.itemId) {
                        R.id.it_android -> {
                            Log.d(TAG, "用户点击了${item?.title}")
                            true
                        }
                        R.id.it_ios -> {
                            Log.d(TAG, "用户点击了${item?.title}")
                            true
                        }
                        else -> {
                            false
                        }
                    }
                }

                override fun onItemCheckedStateChanged(
                    mode: ActionMode?,
                    position: Int,
                    id: Long,
                    checked: Boolean
                ) {
                    Log.d(TAG, "checked===$checked")
                }

                override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                    menuInflater.inflate(R.menu.context_menu, menu)
                    return true
                }

                override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
                    return false
                }

                override fun onDestroyActionMode(mode: ActionMode?) {

                }

            })
        }
    }

    private fun initDatas() {
        data = arrayOf("paper", "cup", "computer")
    }

    companion object {
        private val TAG = "ListViewOnContextual"
    }
}
