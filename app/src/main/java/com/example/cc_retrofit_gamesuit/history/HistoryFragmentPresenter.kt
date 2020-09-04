package com.example.cc_retrofit_gamesuit.history

import com.example.cc_retrofit_gamesuit.database.roomHistory.HistoryGame
import com.example.cc_retrofit_gamesuit.database.roomHistory.HistoryGameDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class HistoryFragmentPresenter (val db: HistoryGameDatabase, val listener: Listener){
    interface Listener{
        fun showHistoryList(history: List<HistoryGame>)
        fun showDeletedSuccess()
        fun showDeletedFailed()
    }

    fun delete(history: HistoryGame){
        GlobalScope.launch {
            val rowDeleted = db.historyGameDao().delete(history)
            if (rowDeleted > 0){
                listener.showDeletedSuccess()
            } else {
                listener.showDeletedFailed()
            }
        }
    }

    fun fetchData(){
        GlobalScope.launch {
            val listHistory = db.historyGameDao().getAll()
            listener.showHistoryList(listHistory)
        }
    }
}