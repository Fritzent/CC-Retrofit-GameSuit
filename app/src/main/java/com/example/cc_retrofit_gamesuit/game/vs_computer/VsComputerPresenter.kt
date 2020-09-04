package com.example.cc_retrofit_gamesuit.game.vs_computer

import android.util.Log
import com.example.cc_retrofit_gamesuit.database.roomHistory.HistoryGame
import com.example.cc_retrofit_gamesuit.database.roomHistory.HistoryGameDatabase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.*

class VsComputerPresenter(private val db: HistoryGameDatabase, private val listener: Listener){
    private lateinit var pilihan: String
    private lateinit var pilihanPemain2: String
    private lateinit var hasil: String
    private lateinit var tanggal: String

    private val gbk = listOf("batu", "gunting", "kertas")


    interface Listener{
        fun tampilHasilMenang()
        fun tampilHasilKalah()
        fun tampilHasilDraw()
        fun batuOnCLick()
        fun guntingOnClick()
        fun kertasOnClick()
        fun batuCom()
        fun kertasCom()
        fun guntingCom()

        fun loveOnClick()

        fun showSaveSuccess()
        fun showSaveFailed()
    }

    fun batuClick(){
        listener.batuOnCLick()
    }

    fun guntingClick(){
        listener.guntingOnClick()
    }

    fun kertasClick(){
        listener.kertasOnClick()
    }

    fun menampilkanHasil(nama: String){
        when(hasil){
            "$nama menang" -> listener.tampilHasilMenang()
            "$nama kalah" -> listener.tampilHasilKalah()
            "$nama draw" -> listener.tampilHasilDraw()
        }
    }

    fun setPilihanPemainSatu(input: String) {
        pilihan = input

        setPilihanPemainDua()

        Log.d("Pilihan Pemain", "Pilihan : $pilihan")
    }

    private fun setPilihanPemainDua() {
        pilihanPemain2 = gbk.random()

        when(pilihanPemain2){
            "batu" -> listener.batuCom()
            "kertas" -> listener.kertasCom()
            "gunting" -> listener.guntingCom()
        }

        Log.d("Pilihan Pemain 2", "Pilihan : $pilihanPemain2")
    }

    fun logicGame(nama: String){
        when (pilihan){
            "batu" -> when (pilihanPemain2){
                "batu" -> hasil = "$nama draw"
                "gunting" -> hasil = "$nama menang"
                "kertas" -> hasil = "$nama kalah"
            }
            "gunting" -> when (pilihanPemain2){
                "batu" -> hasil = "$nama kalah"
                "gunting" -> hasil = "$nama draw"
                "kertas" -> hasil = "$nama menang"
            }
            "kertas" -> when (pilihanPemain2){
                "batu" -> hasil = "$nama menang"
                "gunting" -> hasil = "$nama kalah"
                "kertas" -> hasil = "$nama draw"
            }
        }
    }

    private fun getTanggal(){
        tanggal = SimpleDateFormat("MM/dd/yyyy", Locale.getDefault()).format(Date())
    }

    fun loveClick(idPemain:Int){
        getTanggal()

        val history = HistoryGame(null, idPemain, tanggal, hasil)
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