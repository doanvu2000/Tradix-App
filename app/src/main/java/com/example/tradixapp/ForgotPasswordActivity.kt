package com.example.tradixapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import kotlinx.android.synthetic.main.forgot_password.*

class ForgotPasswordActivity : AppCompatActivity() {
    var time = 5
    val mHandler = Handler(Looper.getMainLooper())
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.forgot_password)

        val thread = Thread(object : Runnable {
            override fun run() {
                mHandler.postDelayed({
                    time--
                    tvWait.text = "Wait $time seconds before sending it"
                    if (time > 0) {
                        mHandler.post(this)
                    }
                    if (time == 0) {
                        btnResendEmail.isEnabled = true
                        btnResendEmail.setBackgroundResource(R.drawable.button_login)
                    }
                }, 1000)
            }
        })
        thread.start()
        btnResendEmail.setOnClickListener {
            startActivity(Intent(this, ConfirmPasswordActivity::class.java))
        }
    }
}

