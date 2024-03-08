package com.brunadev.tm.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.brunadev.tm.databinding.ActivitySplashBinding
import com.brunadev.tm.extension.animationEnd

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

