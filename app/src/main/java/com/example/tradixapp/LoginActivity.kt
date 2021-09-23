package com.example.tradixapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import kotlinx.android.synthetic.main.login.*

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
        var userAcc = ""
        var pass = ""
        if (intent.hasExtra("Email") && intent.hasExtra("Password")) {
            userAcc = intent.getStringExtra("Email").toString()
            pass = intent.getStringExtra("Password").toString()
            edtLoginEmail.setText(userAcc)
            edtLoginPassword.setText(pass)
        }
        btnLogin.setOnClickListener {
            val email: String = edtLoginEmail.text.toString()
            val password: String = edtLoginPassword.text.toString()
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "You must enter your email and password", Toast.LENGTH_SHORT)
                    .show()
            } else
                if (email == "admin" && password == "123" || (email == userAcc && password == pass)) {
                    val loginIntent = Intent(this, MainActivity::class.java)
                    loginIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                    startActivity(loginIntent)
                    Toast.makeText(this, "Login with admin", Toast.LENGTH_SHORT).show()
                }
        }
        btnForgotLogin.setOnClickListener {
            startActivity(Intent(this, ForgotPasswordActivity::class.java))
        }
        btnToSignUp.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}