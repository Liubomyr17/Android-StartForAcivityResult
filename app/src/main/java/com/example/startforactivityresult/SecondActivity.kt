package com.example.startforactivityresult

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        findViewById<Button>(R.id.btn_submit).setOnClickListener{
            val intent = Intent()
            intent.putExtra(MainActivity.NAME, findViewById<EditText>(R.id.et_name).text.toString())
            intent.putExtra(MainActivity.EMAIL, findViewById<EditText>(R.id.et_email).text.toString())
            setResult(Activity.RESULT_OK, intent)
            finish()
        }
    }
}