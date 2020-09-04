package com.example.cc_retrofit_gamesuit.history

import android.content.Context
import android.content.SharedPreferences
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.cc_retrofit_gamesuit.R
import com.example.cc_retrofit_gamesuit.auth.login.LoginActivity
import com.example.cc_retrofit_gamesuit.database.roomHistory.HistoryGame
import kotlinx.android.synthetic.main.history_item.view.*

class HistoryFragmentAdapter (val listHistory: List<HistoryGame>, val presenter: HistoryFragmentPresenter, val sharedPreferences: SharedPreferences): RecyclerView.Adapter<HistoryFragmentAdapter.ViewHolder>(){
    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.history_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val idPemain = sharedPreferences.getInt(LoginActivity.ID, 0)
        if (idPemain == listHistory[position].idPemain){
            holder.itemView.tvHasilTanggal.text = listHistory[position].tanggal
            holder.itemView.tvHasilPertandingan.text = listHistory[position].hasil

            holder.itemView.btnHapus.setOnClickListener{
                presenter.delete(listHistory[position])
            }
        }
    }

    override fun getItemCount(): Int {
        return listHistory.size
    }
}