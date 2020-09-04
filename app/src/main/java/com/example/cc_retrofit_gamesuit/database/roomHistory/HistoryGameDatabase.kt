package com.example.cc_retrofit_gamesuit.database.roomHistory

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [HistoryGame::class], version = 1)
abstract class HistoryGameDatabase: RoomDatabase(){
    abstract fun historyGameDao(): HistoryGameDao

    companion object{
        private var INSTANCE: HistoryGameDatabase? = null

        fun getInstance(context: Context): HistoryGameDatabase? {
            if(INSTANCE == null){
                INSTANCE = Room.databaseBuilder(
                    context,
                    HistoryGameDatabase::class.java,
                    "game_db").build()
            }
            return INSTANCE
        }

        fun destroyInstance(){
            INSTANCE = null
        }
    }
}