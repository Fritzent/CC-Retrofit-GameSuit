package com.example.cc_retrofit_gamesuit.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.cc_retrofit_gamesuit.R

class HistoryGameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_history_game)
    }
}


//TODO INI BAGIAN YANG ERROR DI XML activity_history_game
//<ImageButton
//android:id="@+id/btnBattle"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//app:layout_constraintBottom_toBottomOf="parent"
//app:layout_constraintStart_toStartOf="parent"
//android:src="@drawable/ic_battle"/>
//
//<ImageButton
//android:id="@+id/btnHistory"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//android:layout_marginBottom="16dp"
//app:layout_constraintBottom_toBottomOf="parent"
//app:layout_constraintEnd_toStartOf="@id/btnProfile"
//app:layout_constraintStart_toEndOf="@id/btnBattle"
//android:src="@drawable/ic_history"/>
//
//<ImageButton
//android:id="@+id/btnProfile"
//android:layout_width="wrap_content"
//android:layout_height="wrap_content"
//app:layout_constraintBottom_toBottomOf="parent"
//app:layout_constraintEnd_toEndOf="parent"
//android:src="@drawable/ic_profile"/>