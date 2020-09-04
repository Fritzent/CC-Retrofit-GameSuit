package com.example.cc_retrofit_gamesuit.profil

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.cc_retrofit_gamesuit.R
import com.example.cc_retrofit_gamesuit.auth.login.LoginActivity
import com.example.cc_retrofit_gamesuit.home.HomeActivity
import kotlinx.android.synthetic.main.fragment_edit_email.*
import kotlinx.android.synthetic.main.fragment_edit_username.*
import kotlinx.android.synthetic.main.fragment_profil.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ProfilFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ProfilFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
//    private lateinit var myContext: ProfilFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_profil, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
       // val activity = myContext
        super.onViewCreated(view, savedInstanceState)

        tvIsiUsername.setOnClickListener {
//            val fm  = it.context.supportFragmentManager
//            EditUsernameFragment().show(fm,"Edit Username Fragment")
            (activity as HomeActivity).showEditUser()
        }

        tvIsiEmail.setOnClickListener {
            (activity as HomeActivity).showEditEmail()
        }

        val sharedPreferences = activity?.getSharedPreferences(LoginActivity.SP_NAME, Context.MODE_PRIVATE)

        val username = sharedPreferences?.getString(LoginActivity.FIELD_USERNAME, "Belum Ada Data")
        val email = sharedPreferences?.getString(LoginActivity.FIELD_EMAIL, "Belum Ada Data")

        tvIsiUsername.setText(username)
        tvIsiEmail.setText(email)

    }


    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ProfilFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ProfilFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}