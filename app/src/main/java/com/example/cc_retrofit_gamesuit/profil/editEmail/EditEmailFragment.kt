package com.example.cc_retrofit_gamesuit.profil.editEmail

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import com.example.cc_retrofit_gamesuit.R
import com.example.cc_retrofit_gamesuit.auth.login.LoginActivity
import com.example.cc_retrofit_gamesuit.home.HomeActivity
import com.example.cc_retrofit_gamesuit.profil.editUsername.EditUsernamePresenter
import kotlinx.android.synthetic.main.fragment_edit_email.*
import kotlinx.android.synthetic.main.fragment_edit_username.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [EditEmailFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class EditEmailFragment : DialogFragment(), EditEmailPresenter.Listener {

    private lateinit var presenter: EditEmailPresenter

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        presenter = EditEmailPresenter(this)

        val sharedPreferences =
            activity?.getSharedPreferences(LoginActivity.SP_NAME, Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()

        val username = sharedPreferences?.getString(LoginActivity.FIELD_USERNAME, "Belum Ada Data")
        var email = sharedPreferences?.getString(LoginActivity.FIELD_EMAIL, "Belum Ada Data")
        val id = sharedPreferences?.getInt(LoginActivity.ID, 0)

        etEmailEdit.setText(email)

        btnEmailCancel.setOnClickListener {
            dismiss()
        }

        btnEmailUpdate.setOnClickListener {
            email = etEmailEdit.text.toString()

            if (id != null) {
                sharedPreferences?.let { it1 ->
                    if (username != null) {
                        presenter.updatePerson(
                            username, email!!, id,
                            it1
                        )
                    }
                }
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_edit_email, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment EditEmailFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            EditEmailFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun onUpdatePersonSuccess(message: String) {
        Toast.makeText((activity as HomeActivity), message, Toast.LENGTH_LONG).show()

    }

    override fun onUpdatePersonFailed(errorMessage: String) {
        Toast.makeText((activity as HomeActivity), errorMessage, Toast.LENGTH_LONG).show()
    }
}