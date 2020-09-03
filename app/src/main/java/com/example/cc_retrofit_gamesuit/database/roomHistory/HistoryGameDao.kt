package com.example.cc_retrofit_gamesuit.database.roomHistory

import androidx.room.*

interface HistoryGameDao {
    @Query("SELECT * FROM HistoryGame")
    fun getAll(): List<HistoryGame>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun add(historyGame: HistoryGame): Long

    @Delete
    fun delete(historyGame: HistoryGame): Int

    @Update
    fun update(historyGame: HistoryGame): Int
}