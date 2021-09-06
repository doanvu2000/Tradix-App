package com.example.tradixapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.confirm_password_changed.*

class ConfirmPasswordActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.confirm_password_changed)
        btnConfirmToLogin.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            intent.putExtra("Email", "admin")
            intent.putExtra("Password", "123")
            startActivity(intent)
        }
    }
}