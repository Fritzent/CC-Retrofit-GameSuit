package com.example.cc_retrofit_gamesuit.main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.cc_retrofit_gamesuit.R
import kotlinx.android.synthetic.main.activity_history_game.*

class HistoryGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_game)

        Toast.makeText(this,"Data Masih Kosong", Toast.LENGTH_LONG)

        btnBattle.setOnClickListener {
            val intent = Intent(this, HistoryRecordedActivity::class.java)
            startActivity(intent)

        }
        btnHistory.setOnClickListener {
            val intent = Intent(this, HistoryRecordedActivity::class.java)
            startActivity(intent)

        }
        btnProfile.setOnClickListener {
            val intent = Intent(this, HistoryRecordedActivity::class.java)
            startActivity(intent)

        }
    }
}