package com.example.simpleget

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.URL

class MainActivity : AppCompatActivity() {
    lateinit var tv:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tv=findViewById< TextView>(R.id.tv)
        CoroutineScope(Dispatchers.IO).launch {
            var a = URL("https://dojo-recipes.herokuapp.com/people/").readText(
                Charsets.UTF_8
            )
            this@MainActivity.runOnUiThread(java.lang.Runnable {
                tv.text = a
            })
        }
    }
}