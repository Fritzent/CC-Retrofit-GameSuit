package com.example.cc_retrofit_gamesuit.game.vs_pemain

import android.util.Log

class VsPemainPresenter(val listener: Listener) {
    lateinit var pilihan: String
    lateinit var pilihanPemain2: String
    lateinit var hasil: String

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


}