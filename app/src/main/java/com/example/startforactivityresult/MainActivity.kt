package com.example.startforactivityresult

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    companion object {
        private const val FIRST_ACTIVITY_REQUEST_CODE = 1
        private const val SECOND_ACTIVITY_REQUEST_CODE = 2

        const val NAME = "name"
        const val EMAIL = "email"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.btn_launch_activity_first).setOnClickListener {
            val intent = Intent(this, FirstActivity::class.java)
            startActivityForResult(intent, FIRST_ACTIVITY_REQUEST_CODE)
        }

        findViewById<Button>(R.id.btn_launch_activity_second).setOnClickListener{
            val intent = Intent(this, SecondActivity::class.java)
            startActivityForResult(intent, SECOND_ACTIVITY_REQUEST_CODE)
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == FIRST_ACTIVITY_REQUEST_CODE) {
                findViewById<TextView>(R.id.tv_first_activity_result).text = "First Activity Result Success"
            } else if (requestCode == SECOND_ACTIVITY_REQUEST_CODE){
                if (data != null) {
                    val name = data.getStringExtra(NAME)
                    val email = data.getStringExtra(EMAIL)

                    findViewById<TextView>(R.id.tv_second_activity_result).text = "$name => $email"
            }
            }
        } else if (resultCode == Activity.RESULT_CANCELED) {
            Log.e("Cancelled", "Canceled")
            Toast.makeText(this@MainActivity,
                   "Result Cancelled", Toast.LENGTH_SHORT).show()

        }

}
}