package com.vneuron.bhbankexample.login

import android.app.Activity
import android.content.Intent
import android.graphics.Color
import android.hardware.biometrics.BiometricPrompt
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.biometric.BiometricManager
import androidx.core.content.ContextCompat
import com.vneuron.bhbankexample.R
import com.vneuron.bhbankexample.main.MainActivity
import kotlinx.android.synthetic.main.activity_login.*
import java.util.concurrent.Executor

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        changeStatusBarToTransparent(this)
        setContentView(R.layout.activity_login)

        val executor = ContextCompat.getMainExecutor(this)
        val biometricManager = BiometricManager.from(this)
        when (biometricManager.canAuthenticate()) {
            BiometricManager.BIOMETRIC_SUCCESS ->
                authUser(executor)
            BiometricManager.BIOMETRIC_ERROR_NO_HARDWARE ->
                Toast.makeText(
                    this,
                    "no_biometric_hardware",
                    Toast.LENGTH_LONG
                ).show()
            BiometricManager.BIOMETRIC_ERROR_HW_UNAVAILABLE ->
                Toast.makeText(
                    this,
                    "biometric_hw_unavailable",
                    Toast.LENGTH_LONG
                ).show()
            BiometricManager.BIOMETRIC_ERROR_NONE_ENROLLED ->
                Toast.makeText(
                    this,
                    "biometric_not_setup",
                    Toast.LENGTH_LONG
                ).show()
        }


    }

    private fun authUser(executor: Executor) {
        // 1
        val promptInfo = androidx.biometric.BiometricPrompt.PromptInfo.Builder()
            // 2
            .setTitle("auth_title")
            // 3
            .setSubtitle("auth_subtitle")
            // 4
            .setDescription("auth_description")
            // 5
            .setDeviceCredentialAllowed(true)
            // 6
            .build()
        // 1
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            val biometricPrompt = androidx.biometric.BiometricPrompt(this, executor,
                object : androidx.biometric.BiometricPrompt.AuthenticationCallback() {
                    // 2
                    override fun onAuthenticationSucceeded(result: androidx.biometric.BiometricPrompt.AuthenticationResult) {
                        super.onAuthenticationSucceeded(result)
                        fingerprint_layout.visibility = View.VISIBLE
                        startActivity(Intent(this@LoginActivity,MainActivity::class.java))
                        finish()
                    }
                    // 3
                    override fun onAuthenticationError(
                        errorCode: Int, errString: CharSequence
                    ) {
                        super.onAuthenticationError(errorCode, errString)
                        Toast.makeText(
                            applicationContext,
                            "error_msg_auth_error",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    // 4
                    override fun onAuthenticationFailed() {
                        super.onAuthenticationFailed()
                        Toast.makeText(applicationContext,
                            "error_msg_auth_failed",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                })

            biometricPrompt.authenticate(promptInfo)
        }
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