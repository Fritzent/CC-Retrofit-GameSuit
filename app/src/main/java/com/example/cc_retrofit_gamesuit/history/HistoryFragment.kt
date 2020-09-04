package com.example.cc_retrofit_gamesuit.history

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cc_retrofit_gamesuit.R
import com.example.cc_retrofit_gamesuit.auth.login.LoginActivity
import com.example.cc_retrofit_gamesuit.database.roomHistory.HistoryGame
import com.example.cc_retrofit_gamesuit.database.roomHistory.HistoryGameDatabase
import com.example.cc_retrofit_gamesuit.home.HomeActivity
import com.example.cc_retrofit_gamesuit.main.MainActivity
import kotlinx.android.synthetic.main.fragment_history.*

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HistoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HistoryFragment : Fragment(), HistoryFragmentPresenter.Listener {

    private lateinit var presenter: HistoryFragmentPresenter

    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onResume() {
        super.onResume()

        presenter.fetchData()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_history, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        HistoryGameDatabase.getInstance((activity as HomeActivity))?.let {
            presenter = HistoryFragmentPresenter(it, this)
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HistoryFragment.
         */
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HistoryFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun showHistoryList(history: List<HistoryGame>) {
        activity?.runOnUiThread {
            val sharedPreferences = activity?.getSharedPreferences(LoginActivity.SP_NAME, Context.MODE_PRIVATE)
            val adapter = sharedPreferences?.let { HistoryFragmentAdapter(history, presenter, it) }
            rvHistoryCOntainer.layoutManager =
                LinearLayoutManager((activity as HomeActivity), LinearLayoutManager.VERTICAL, false)
            rvHistoryCOntainer.adapter = adapter
        }
    }

    override fun showDeletedSuccess() {
        activity?.runOnUiThread {
            Toast.makeText((activity as HomeActivity), "Data history Telah dihapus", Toast.LENGTH_LONG).show()
            presenter.fetchData()
        }
    }

    override fun showDeletedFailed() {
        activity?.runOnUiThread {
            Toast.makeText((activity as HomeActivity), "Data history Gagal dihapus", Toast.LENGTH_LONG).show()
        }
    }
}