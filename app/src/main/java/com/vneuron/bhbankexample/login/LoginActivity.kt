package com.vneuron.bhbankexample.login

import android.app.Activity
import android.graphics.Color
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import com.vneuron.bhbankexample.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        changeStatusBarToTransparent(this)
        setContentView(R.layout.activity_login)

    }

    companion object{
        fun changeStatusBarToWhite(activity:Activity){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                activity.window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
                activity.window.statusBarColor = Color.WHITE
            }
        }
        fun changeStatusBarToTransparent(activity:Activity){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                activity.window.setFlags(
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                    WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)

            }
        }
    }


}