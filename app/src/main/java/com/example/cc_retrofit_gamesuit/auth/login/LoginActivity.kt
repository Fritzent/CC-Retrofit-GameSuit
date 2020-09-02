package com.example.cc_retrofit_gamesuit.auth.login

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.cc_retrofit_gamesuit.auth.register.RegisterActivity
import com.example.cc_retrofit_gamesuit.databinding.ActivityLoginBinding
import com.example.cc_retrofit_gamesuit.main.MainActivity

class LoginActivity : AppCompatActivity(), LoginActivityPresenter.Listener {

    private lateinit var presenter: LoginActivityPresenter
    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        presenter = LoginActivityPresenter(this)

        //ini untuk ngirim data login ketika user menekan tombol login
        binding.btnLogin.setOnClickListener {
            //ini kumpulan logic untuk user logic
            if(binding.etUsername.text.isEmpty() && binding.etPassword.text.isEmpty()){
                Toast.makeText(this, "Username dan Password Kosong", Toast.LENGTH_LONG).show()
                binding.etUsername.requestFocus()
            }else if(binding.etUsername.text.isEmpty() && binding.etPassword.text.isNotEmpty()){
                Toast.makeText(this, "Username anda kosong", Toast.LENGTH_LONG).show()
                binding.etUsername.requestFocus()
            }else if(binding.etUsername.text.isNotEmpty() && binding.etPassword.text.isEmpty()){
                Toast.makeText(this, "Password anda kosong", Toast.LENGTH_LONG).show()
                binding.etPassword.requestFocus()
            }else{
                presenter.loginPerson(binding.etUsername.text.toString(), binding.etPassword.text.toString())
            }
        }
        binding.btnRegister.setOnClickListener {
            startActivity(Intent(applicationContext, RegisterActivity::class.java))
        }
    }
    override fun onLoginSuccess(successMessage: String) {
        Toast.makeText(this, successMessage, Toast.LENGTH_LONG).show()
        startActivity(Intent(applicationContext, MainActivity::class.java))
        finish()
    }

    override fun onLoginFailure(failureMessage: String) {
        Toast.makeText(this, failureMessage, Toast.LENGTH_LONG).show()
        finish()
    }
}