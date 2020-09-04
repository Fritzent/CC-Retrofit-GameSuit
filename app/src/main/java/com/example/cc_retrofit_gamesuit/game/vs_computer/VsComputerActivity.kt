package com.example.cc_retrofit_gamesuit.game.vs_computer

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cc_retrofit_gamesuit.R
import com.example.cc_retrofit_gamesuit.auth.login.LoginActivity
import com.example.cc_retrofit_gamesuit.database.roomHistory.HistoryGameDatabase
import com.example.cc_retrofit_gamesuit.databinding.ActivityGameBinding
import kotlinx.android.synthetic.main.activity_game.*

class VsComputerActivity : AppCompatActivity(), VsComputerPresenter.Listener {
    private lateinit var binding: ActivityGameBinding
    private lateinit var presenter: VsComputerPresenter
    private var nama: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {}

        binding = ActivityGameBinding.inflate(layoutInflater)
        HistoryGameDatabase.getInstance(this)?.let {
            presenter = VsComputerPresenter(it, this)
        }

        val sharedPreferences = getSharedPreferences(LoginActivity.SP_NAME, Context.MODE_PRIVATE)

        nama = sharedPreferences.getString("username", "Tidak ada username")

        binding.tvPemain.text = nama

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
        nama?.let { presenter.logicGame(it) }
        nama?.let { presenter.menampilkanHasil(it) }

        binding.loveBTN.setOnClickListener {
            presenter.loveClick()
        }

        binding.ivBatuPemain.isClickable = false
        binding.ivGuntingPemain.isClickable = false
        binding.ivKertasPemain.isClickable = false

        binding.ivBatuPemain.setBackgroundResource(R.drawable.bg_click)
    }

    override fun guntingOnClick() {
        presenter.setPilihanPemainSatu("gunting")
        nama?.let { presenter.logicGame(it) }
        nama?.let { presenter.menampilkanHasil(it) }

        binding.loveBTN.setOnClickListener {
            presenter.loveClick()
        }

        binding.ivBatuPemain.isClickable = false
        binding.ivGuntingPemain.isClickable = false
        binding.ivKertasPemain.isClickable = false

        binding.ivGuntingPemain.setBackgroundResource(R.drawable.bg_click)
    }

    override fun kertasOnClick() {
        presenter.setPilihanPemainSatu("kertas")
        nama?.let { presenter.logicGame(it) }
        nama?.let { presenter.menampilkanHasil(it) }

        binding.loveBTN.setOnClickListener {
            presenter.loveClick()
        }

        binding.ivBatuPemain.isClickable = false
        binding.ivGuntingPemain.isClickable = false
        binding.ivKertasPemain.isClickable = false

        binding.ivKertasPemain.setBackgroundResource(R.drawable.bg_click)
    }

    override fun batuCom() {
        binding.ivBatuCom.setBackgroundResource(R.drawable.bg_click)
    }

    override fun kertasCom() {
        binding.ivKertasCom.setBackgroundResource(R.drawable.bg_click)
    }

    override fun guntingCom() {
        binding.ivGuntingCom.setBackgroundResource(R.drawable.bg_click)
    }

    override fun loveOnClick() {
        binding.loveBTN.setImageResource(R.drawable.ic_save_active)
        binding.loveBTN.isClickable = false
    }

    override fun showSaveSuccess() {
        runOnUiThread {
            Toast.makeText(this, "Data telah disimpan", Toast.LENGTH_SHORT).show()
        }
    }

    override fun showSaveFailed() {
        runOnUiThread {
            Toast.makeText(this, "Data gagal disimpan", Toast.LENGTH_SHORT).show()
        }
    }
}