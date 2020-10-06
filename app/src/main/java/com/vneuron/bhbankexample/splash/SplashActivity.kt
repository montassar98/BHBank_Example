package com.vneuron.bhbankexample.splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import com.vneuron.bhbankexample.R
import com.vneuron.bhbankexample.login.LoginActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoginActivity.changeStatusBarToTransparent(this)
        setContentView(R.layout.activity_splash)
        Handler(Looper.myLooper()!!).postDelayed(Runnable {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
        },5000)

    }
}