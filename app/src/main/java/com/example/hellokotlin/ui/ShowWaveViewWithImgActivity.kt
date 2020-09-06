package com.example.hellokotlin.ui

import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.hellokotlin.R
import com.example.hellokotlin.widgets.GuideView
import com.example.hellokotlin.widgets.WaveView

class ShowWaveViewWithImgActivity : AppCompatActivity() {
    lateinit var mWvLeftLang: WaveView
    var showWave: Boolean = false
    lateinit var guideView: GuideView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_wave_view_with_img)
        mWvLeftLang = findViewById(R.id.wv_left_lang)
        mWvLeftLang.setInitialRadius(79f)
        mWvLeftLang.setMaxRadius(206f)
//        mWvLeftLang.setColor(0xffea5928.toInt())
//        mWvLeftLang.start()
        mWvLeftLang.setOnClickListener {
            mWvLeftLang.start()
            setGuideView()
        }
    }

    private fun setGuideView() {
        // 使用文字
        val tv = TextView(this)
        tv.text = ""
        tv.setTextColor(resources.getColor(R.color.colorAccent))
        tv.textSize = 30f
        tv.gravity = Gravity.CENTER
        guideView = GuideView.Builder
            .newInstance(this)
            .setTargetView(mWvLeftLang) //设置目标
            .setCustomGuideView(tv)
            .setDirction(GuideView.Direction.LEFT_BOTTOM)
            .setShape(GuideView.MyShape.CIRCULAR) // 设置圆形显示区域，
            .setBgColor(resources.getColor(R.color.shadow))
            .setOnclickListener {
                guideView.hide()
                mWvLeftLang.stopImmediately()
//                mWvLeftLang.stop()
            }
            .build()
        guideView.show()
    }
}
