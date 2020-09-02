package com.example.cc_retrofit_gamesuit.auth.login

import com.example.cc_retrofit_gamesuit.network.ApiClient
import com.example.cc_retrofit_gamesuit.response.PostPersonLoginBody
import com.example.cc_retrofit_gamesuit.response.PostPersonLoginResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivityPresenter(val listener : Listener) {
    fun loginPerson(email : String, password: String){
        val person =
            PostPersonLoginBody(
                email,
                password
            )

        ApiClient.apiService.loginPerson(person).enqueue(object : Callback<PostPersonLoginResponse> {
            override fun onFailure(call: Call<PostPersonLoginResponse>, t: Throwable) {
                listener.onLoginFailure(t.toString())
            }

            override fun onResponse(
                call: Call<PostPersonLoginResponse>,
                response: Response<PostPersonLoginResponse>
            ) {
                if(response.isSuccessful && response.body()?.status == 200) {
                    listener.onLoginSuccess("${response.body()?.message}")
                }else {
                    listener.onLoginFailure("${response.body()?.message}")
                }
            }
        })
    }

    interface Listener{
        fun onLoginSuccess(successMessage: String)
        fun onLoginFailure(failureMessage: String)
    }

}