package com.example.tradixapp

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController

class TutorialActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tutorial)
//        val share : SharedPreferences = getPreferences(MODE_PRIVATE)
//        if (share.getBoolean("active",false)){
//            finishAndRemoveTask()
//        }
    }
}