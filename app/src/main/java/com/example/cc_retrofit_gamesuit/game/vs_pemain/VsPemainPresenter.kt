package com.example.cc_retrofit_gamesuit.game.vs_pemain

import android.util.Log
import com.example.cc_retrofit_gamesuit.database.roomHistory.HistoryGame
import com.example.cc_retrofit_gamesuit.database.roomHistory.HistoryGameDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class VsPemainPresenter(private val db: HistoryGameDatabase, private val listener: Listener) {
    private lateinit var pilihan: String
    private lateinit var pilihanPemain2: String
    private lateinit var hasil: String
    private lateinit var tanggal: String

    interface Listener {
        fun tampilHasilMenang()
        fun tampilHasilKalah()
        fun tampilHasilDraw()
        fun batuP1onClick()
        fun guntingP1onClick()
        fun kertasP1onClick()
        fun batuP2onCLick()
        fun guntingP2onCLick()
        fun kertasP2onClick()
        fun loveOnClick()

        fun showSaveSuccess()
        fun showSaveFailed()
    }



    fun batuP1(){
        listener.batuP1onClick()
    }

    fun guntingP1(){
        listener.guntingP1onClick()
    }

    fun kertasP1(){
        listener.kertasP1onClick()
    }

    fun batuP2(){
        listener.batuP2onCLick()
    }

    fun guntingP2(){
        listener.guntingP2onCLick()
    }

    fun kertasP2(){
        listener.kertasP2onClick()
    }

    fun menampilkanHasil(){
        when(hasil){
            "menang" -> listener.tampilHasilMenang()
            "kalah" -> listener.tampilHasilKalah()
            "draw" -> listener.tampilHasilDraw()
        }
    }

    fun setPilihanPemainSatu(input: String) {
        pilihan = input

        Log.d("Pilihan Pemain", "Pilihan : $pilihan")
    }

    fun setPilihanPemainDua(input: String) {
        pilihanPemain2 = input

        Log.d("Pilihan Pemain 2", "Pilihan : $pilihanPemain2")
    }

    fun logicGame(){

        when (pilihan){
            "batu" -> when (pilihanPemain2){
                "batu" -> hasil = "draw"
                "gunting" -> hasil = "menang"
                "kertas" -> hasil = "kalah"
            }
            "gunting" -> when (pilihanPemain2){
                "batu" -> hasil = "kalah"
                "gunting" -> hasil = "draw"
                "kertas" -> hasil = "menang"
            }
            "kertas" -> when (pilihanPemain2){
                "batu" -> hasil = "menang"
                "gunting" -> hasil = "kalah"
                "kertas" -> hasil = "draw"
            }
        }
    }

    private fun getTanggal(){
        tanggal = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault()).format(Date())
    }

    fun loveClick(){
        getTanggal()

        val history = HistoryGame(null, tanggal, hasil)
        saveHistory(history)

        listener.loveOnClick()
    }


    private fun saveHistory(historyGame: HistoryGame){
        GlobalScope.launch {
            val totalSaved = db.historyGameDao().add(historyGame)

            Log.d("Hasil", "${historyGame.hasil}, ${historyGame.tanggal}")
            if (totalSaved > 0) {
                listener.showSaveSuccess()
            } else {
                listener.showSaveFailed()
            }
        }
    }


}