package com.example.cc_retrofit_gamesuit.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentTransaction
import com.example.cc_retrofit_gamesuit.R
import com.example.cc_retrofit_gamesuit.databinding.ActivityHomeBinding
import com.example.cc_retrofit_gamesuit.profil.EditEmailFragment
import com.example.cc_retrofit_gamesuit.profil.EditUsernameFragment
import com.example.cc_retrofit_gamesuit.profil.ProfilFragment

class HomeActivity : AppCompatActivity() {

    private lateinit var binding : ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val botNav = binding.bottomNavigation

        try {
            this.supportActionBar?.hide()
        } catch (e: NullPointerException) {}

        val homeFragment = HomeFragment()
        val profilFragment = ProfilFragment()

        //default fragment
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.frameHomecontainer, homeFragment)
            .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
            .commit()

        botNav.setOnNavigationItemSelectedListener {
            return@setOnNavigationItemSelectedListener when (it.itemId) {
                R.id.navBattle -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameHomecontainer, homeFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    true
                }

                R.id.navHistory -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameHomecontainer, profilFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    true
                }

                R.id.navProfile -> {
                    supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.frameHomecontainer, profilFragment)
                        .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                        .commit()
                    true
                }

                else -> false
            }
        }
    }
    fun showEditUser() {
        val fm  = supportFragmentManager
        EditUsernameFragment().show(fm,"Edit Username Fragment")
    }
    fun showEditEmail() {
        val fm  = supportFragmentManager
        EditEmailFragment().show(fm,"Edit Username Fragment")
    }
}