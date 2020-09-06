package com.example.hellokotlin

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.hellokotlin.listview.IndividualViewActivity
import com.example.hellokotlin.listview.ListViewOnContextualMenusActivity
<<<<<<< HEAD
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
=======
import com.example.hellokotlin.menu.pop.PopMenusActivity
import com.example.hellokotlin.ui.AnimationActivity
import com.example.hellokotlin.ui.ShowWaveViewWithImgActivity
import java.lang.StringBuilder
>>>>>>> 0f7499094af016a5e2d0c167f3810195d69bc56e

class MainActivity : AppCompatActivity() {
    private lateinit var next: Button
    private lateinit var tv_hello: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG,"onCreate")
        initView()
        testApply()
        testLet()
    }

    private fun testLet() {
        val a = listOf("a", "b", "c").let { it.size }
        Log.d(TAG, "a=$a")
    }

    private fun testApply() {
        StringBuilder("abc").apply {
            append("efg")
            Log.d(TAG, "stringbuild value is $this")
        }
    }


    private fun initView() {
        initNext()
        initLv()
        initContextMenu()
        initIndividual()
        initPop()
        showWaveViewWithImg()
        intentToAnimationActivity()
    }

    private fun intentToAnimationActivity() {
        findViewById<Button>(R.id.btn_animation).setOnClickListener {
            startActivity(Intent(this, AnimationActivity::class.java))
        }
    }

    private fun showWaveViewWithImg() {
        findViewById<Button>(R.id.btn_show_wave_view_img).setOnClickListener {
            startActivity(Intent(this, ShowWaveViewWithImgActivity::class.java))
        }
    }

    private fun initPop() {
        findViewById<Button>(R.id.btn_pop).setOnClickListener {
            startActivity(Intent(this, PopMenusActivity::class.java))
        }
    }

    private fun initIndividual() {
        findViewById<Button>(R.id.btn_individual).setOnClickListener() {
            startActivity(Intent(this, IndividualViewActivity::class.java))
        }
    }

    private fun initContextMenu() {
        findViewById<Button>(R.id.btn_contextual_menu).setOnClickListener() {
            startActivity(Intent(this, ListViewOnContextualMenusActivity::class.java))
        }
    }

    private fun initLv() {
<<<<<<< HEAD
//        findViewById<Button>(R.id.btn_lv).setOnClickListener() {
//            startActivity(Intent(this, ListViewActivity::class.java))
//        }
        EventBus.getDefault().post("Hi")
=======
        findViewById<Button>(R.id.btn_lv).setOnClickListener() {
            startActivity(Intent(this, ListViewActivity::class.java))
        }
>>>>>>> 0f7499094af016a5e2d0c167f3810195d69bc56e
    }

    private fun initNext() {
        next = findViewById(R.id.btn_next)
        tv_hello = findViewById(R.id.tv_hello)
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
        when (item.itemId) {
            R.id.it_tiger -> {
                if (!item.isChecked) {
<<<<<<< HEAD
                    item.isChecked = true
=======
                    item.setChecked(true)
>>>>>>> 0f7499094af016a5e2d0c167f3810195d69bc56e
                }
            }
            R.id.it_panda -> {
                if (!item.isChecked) {
<<<<<<< HEAD
                    item.isChecked = true
=======
                    item.setChecked(true)
>>>>>>> 0f7499094af016a5e2d0c167f3810195d69bc56e
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
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onStart() {
        super.onStart()
        Log.d(TAG,"onStart")
        EventBus.getDefault().register(this)
    }

    override fun onStop() {
        super.onStop()
        EventBus.getDefault().unregister(this)
    }

    @Subscribe
    fun setText(a: String) {
        Log.d(TAG,"setText")
        Toast.makeText(this,"setText",Toast.LENGTH_LONG).show()
        tv_hello.text = a
    }

}
