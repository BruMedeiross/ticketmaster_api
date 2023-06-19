package com.brunadev.bookstore.view

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.adapters.ViewGroupBindingAdapter.setListener
import com.brunadev.bookstore.R
import com.brunadev.bookstore.databinding.ActivityMainBinding
import com.brunadev.bookstore.databinding.ActivitySplashBinding
import com.brunadev.bookstore.extension.animationEnd

class SplashActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.splashImg.animate().apply {
            setListener(animationEnd {
                goToMainScreen()
            })
            duration = 1000
            alpha(1.0f)
            start()
        }
    }

    fun goToMainScreen() {
        val intent = Intent(this, MainActivity::class.java)
        binding.splashImg.animate().apply {
            setListener(animationEnd {
                startActivity(intent)
            })
            duration = 1000
            alpha(0.0f)
            start()
        }
    }

}

