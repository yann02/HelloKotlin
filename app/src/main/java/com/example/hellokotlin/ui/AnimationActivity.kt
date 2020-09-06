package com.example.hellokotlin.ui

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import com.example.hellokotlin.R

class AnimationActivity : AppCompatActivity() {
    private lateinit var contentViews: View
    private lateinit var loadingView: View
    private var shortAnimationDuration: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)
        contentViews = findViewById(R.id.content)
        loadingView = findViewById(R.id.loading_spinner)
//        contentViews.visibility = View.GONE
//        shortAnimationDuration = resources.getInteger(android.R.integer.config_longAnimTime)
        shortAnimationDuration = 2000
        Handler().postDelayed({
            crossfade()
        },5000)
    }
    private fun crossfade() {
        contentViews.apply {
            alpha = 0f
            visibility = View.VISIBLE
            animate()
                .alpha(1f)
                .setDuration(shortAnimationDuration.toLong())
                .setListener(null)
        }
        loadingView.animate()
            .alpha(0f)
            .setDuration(shortAnimationDuration.toLong())
            .setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    loadingView.visibility = View.GONE
                }
            })
    }
}
