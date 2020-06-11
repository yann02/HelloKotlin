package com.example.hellokotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import com.example.hellokotlin.listview.IndividualViewActivity
import com.example.hellokotlin.listview.ListViewActivity
import com.example.hellokotlin.listview.ListViewOnContextualMenusActivity

class MainActivity : AppCompatActivity() {
    private lateinit var next: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        initNext()
        initLv()
        initContextMenu()
        initIndividual()
    }

    private fun initIndividual() {
        findViewById<Button>(R.id.btn_individual).setOnClickListener(){
            startActivity(Intent(this,IndividualViewActivity::class.java))
        }
    }

    private fun initContextMenu() {
        findViewById<Button>(R.id.btn_contextual_menu).setOnClickListener(){
            startActivity(Intent(this,ListViewOnContextualMenusActivity::class.java))
        }
    }

    private fun initLv() {
        findViewById<Button>(R.id.btn_lv).setOnClickListener(){
            startActivity(Intent(this,ListViewActivity::class.java))
        }
    }

    private fun initNext() {
        next = findViewById(R.id.btn_next)
        next.setOnClickListener() {
            val nextIntent = Intent().apply {
                action = "123"
                putExtra("abc", "Job")
                type = "text/plain"
            }
            if (nextIntent.resolveActivity(packageManager) != null) {
                startActivity(nextIntent)
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d(TAG, "clicked item's id is ${item.itemId}")
        when(item.itemId){
            R.id.it_tiger->{
                if (!item.isChecked){
                    item.setChecked(true)
                }
            }
            R.id.it_panda->{
                if (!item.isChecked){
                    item.setChecked(true)
                }
            }
        }
        return true
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context_menu,menu)
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}
