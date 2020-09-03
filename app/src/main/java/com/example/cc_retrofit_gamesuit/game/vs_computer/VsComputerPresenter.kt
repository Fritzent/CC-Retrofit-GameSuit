package com.example.cc_retrofit_gamesuit.game.vs_computer

import android.util.Log

class VsComputerPresenter(private val listener: Listener){
    private lateinit var pilihan: String
    private lateinit var pilihanPemain2: String
    private lateinit var hasil: String

    private val gbk = listOf("batu", "gunting", "kertas")


    interface Listener{
        fun tampilHasilMenang()
        fun tampilHasilKalah()
        fun tampilHasilDraw()
        fun batuOnCLick()
        fun guntingOnClick()
        fun kertasOnClick()
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

    fun menampilkanHasil(){
        when(hasil){
            "menang" -> listener.tampilHasilMenang()
            "kalah" -> listener.tampilHasilKalah()
            "draw" -> listener.tampilHasilDraw()
        }
    }

    fun setPilihanPemainSatu(input: String) {
        pilihan = input

        setPilihanPemainDua()

        Log.d("Pilihan Pemain", "Pilihan : $pilihan")
    }

    private fun setPilihanPemainDua() {
        pilihanPemain2 = gbk.random()

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
}