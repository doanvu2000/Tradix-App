package com.example.tradixapp

import `object`.User
import adapter.ListCoinAdapter
import adapter.TitleHomeAdapter
import android.app.ActivityManager
import android.app.AlertDialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import androidx.recyclerview.widget.*
import fragment.CoinFragment
import fragment.HomeFragment
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.home.*

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    var activityManager: ActivityManager? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (activityManager == null) {
            activityManager = getSystemService(ACTIVITY_SERVICE) as ActivityManager?;
        }
        Log.d(TAG, "${getAppTaskState()}")

        val navController = findNavController(R.id.fragment)
        bottom_navigation.setupWithNavController(navController)
    }

    override fun onBackPressed() {

        val dialog = AlertDialog.Builder(this)
        dialog.setTitle("Are you sure!")
            .setMessage("Do you want to exit app?")
            .setNegativeButton("No") { _: DialogInterface, _: Int -> }
            .setPositiveButton("Yes") { _: DialogInterface, _: Int ->
                finish()
            }
            .show()
    }

    private fun getAppTaskState(): String? {
        val stringBuilder = StringBuilder()
        val totalNumberOfTasks =
            activityManager!!.getRunningTasks(10).size //Returns total number of tasks - stacks
        stringBuilder.append("\nTotal Number of Tasks: $totalNumberOfTasks\n\n")
        val taskInfo = activityManager!!.getRunningTasks(10)
        for (info in taskInfo) {
            stringBuilder.append("Task Id: ${info.id}, Number of Activities : ${info.numActivities}\n");
            stringBuilder.append(
                "TopActivity: " + info.topActivity?.className.toString()
                    .replace("com.example.launchmodedemo.", "") + "\n"
            );
            stringBuilder.append(
                "BaseActivity:" + info.baseActivity?.className.toString()
                    .replace("com.example.launchmodedemo.", "") + "\n"
            );
            stringBuilder.append("\n\n");
        }
        return stringBuilder.toString()
    }


}