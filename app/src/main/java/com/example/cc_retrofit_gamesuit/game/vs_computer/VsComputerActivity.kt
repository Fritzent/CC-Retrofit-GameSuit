package com.example.cc_retrofit_gamesuit.game.vs_computer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.cc_retrofit_gamesuit.R
import com.example.cc_retrofit_gamesuit.databinding.ActivityGameBinding
import kotlin.system.exitProcess

class VsComputerActivity : AppCompatActivity(), VsComputerPresenter.Listener {
    private lateinit var binding: ActivityGameBinding
    private lateinit var presenter: VsComputerPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {}

        binding = ActivityGameBinding.inflate(layoutInflater)
        presenter = VsComputerPresenter(this)

        val view = binding.root

        binding.ivBatuPemain.setOnClickListener{
            presenter.batuClick()
        }

        binding.ivGuntingPemain.setOnClickListener {
            presenter.guntingClick()
        }

        binding.ivKertasPemain.setOnClickListener {
            presenter.kertasClick()
        }

        binding.ivRestart.setOnClickListener {
            binding.ivBatuPemain.isClickable = true
            binding.ivGuntingPemain.isClickable = true
            binding.ivKertasPemain.isClickable = true

            binding.ivKertasCom.setBackgroundResource(0)
            binding.ivBatuCom.setBackgroundResource(0)
            binding.ivGuntingCom.setBackgroundResource(0)

            binding.ivKertasPemain.setBackgroundResource(0)
            binding.ivBatuPemain.setBackgroundResource(0)
            binding.ivGuntingPemain.setBackgroundResource(0)

            binding.ivHasilPertandingan.setImageResource(R.drawable.vs)
        }

        binding.loveBTN.setOnClickListener {
            binding.loveBTN.setImageResource(R.drawable.ic_save_active)
        }

        binding.backBTN.setOnClickListener {
            finish()
        }

        setContentView(view)
    }

    override fun tampilHasilMenang() {
        binding.ivHasilPertandingan.setImageResource(R.drawable.pemain_menang)
        Log.d("hasil pertandingan", "Pemain Menang")
    }

    override fun tampilHasilKalah() {
        binding.ivHasilPertandingan.setImageResource(R.drawable.computer_menang)
        Log.d("hasil pertandingan", "Pemain Menang")
    }

    override fun tampilHasilDraw() {
        binding.ivHasilPertandingan.setImageResource(R.drawable.draw)
        Log.d("hasil pertandingan", "Pemain Menang")
    }

    override fun batuOnCLick() {
        presenter.setPilihanPemainSatu("batu")
        presenter.logicGame()
        presenter.menampilkanHasil()


        binding.ivBatuPemain.isClickable = false
        binding.ivGuntingPemain.isClickable = false
        binding.ivKertasPemain.isClickable = false

        binding.ivBatuPemain.setBackgroundResource(R.drawable.bg_click)
    }

    override fun guntingOnClick() {
        presenter.setPilihanPemainSatu("gunting")
        presenter.logicGame()
        presenter.menampilkanHasil()

        binding.ivBatuPemain.isClickable = false
        binding.ivGuntingPemain.isClickable = false
        binding.ivKertasPemain.isClickable = false

        binding.ivGuntingPemain.setBackgroundResource(R.drawable.bg_click)
    }

    override fun kertasOnClick() {
        presenter.setPilihanPemainSatu("kertas")
        presenter.logicGame()
        presenter.menampilkanHasil()

        binding.ivBatuPemain.isClickable = false
        binding.ivGuntingPemain.isClickable = false
        binding.ivKertasPemain.isClickable = false

        binding.ivKertasPemain.setBackgroundResource(R.drawable.bg_click)
    }
}