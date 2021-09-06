package com.example.tradixapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.register.*

class RegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.register)
        btnSignUp.setOnClickListener {
            val email: String = edtRegisterEmail.text.toString()
            val password: String = edtRegisterPassword.text.toString()
            val inte = Intent(this, LoginActivity::class.java)
            inte.putExtra("Email", email)
            inte.putExtra("Password", password)
            startActivity(inte)
        }
        btnForgotRegister.setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }
        btnToLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}