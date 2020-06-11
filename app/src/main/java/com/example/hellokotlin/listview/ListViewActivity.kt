package com.example.hellokotlin.listview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.AbsListView
import android.widget.AdapterView
import android.widget.ListView
import com.example.hellokotlin.R

class ListViewActivity : AppCompatActivity() {
    private lateinit var listview: ListView
    private lateinit var data: Array<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        initData()
        initView()
    }

    private fun initData() {
        data = arrayOf("paper", "cup", "computer")
    }

    private fun initView() {
        listview = findViewById(R.id.lv_main)
        listview.adapter = ListViewAdapter(data,this)
        registerForContextMenu(listview)
//        with(listview){
//            choiceMode=ListView.CHOICE_MODE_MULTIPLE_MODAL
//            setMultiChoiceModeListener(object :AbsListView.MultiChoiceModeListener{
//                override fun onActionItemClicked(mode: ActionMode?, item: MenuItem?): Boolean {
//                    TODO("Not yet implemented")
//                }
//
//                override fun onItemCheckedStateChanged(
//                    mode: ActionMode?,
//                    position: Int,
//                    id: Long,
//                    checked: Boolean
//                ) {
//                    TODO("Not yet implemented")
//                }
//
//                override fun onCreateActionMode(mode: ActionMode?, menu: Menu?): Boolean {
//                    TODO("Not yet implemented")
//                }
//
//                override fun onPrepareActionMode(mode: ActionMode?, menu: Menu?): Boolean {
//                    return false
//                }
//
//                override fun onDestroyActionMode(mode: ActionMode?) {
//                    TODO("Not yet implemented")
//                }
//
//            })
//        }
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu,menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        val info = item.menuInfo as AdapterView.AdapterContextMenuInfo
        return when (item.itemId) {
            R.id.it_android -> {
                Log.d(TAG,"info.id=${info.id}")
                true
            }
            R.id.it_ios -> {
                Log.d(TAG,"info.id=${info.id}")
                true
            }
            else -> super.onContextItemSelected(item)
        }
    }

    companion object{
        const val TAG="ListViewActivity"
    }
}
