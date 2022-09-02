package com.mirai.challengeflow.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.mirai.challengeflow.R
import com.mirai.challengeflow.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}