package com.example.cc_retrofit_gamesuit.profil.editEmail

import android.content.SharedPreferences
import com.example.cc_retrofit_gamesuit.auth.login.LoginActivity
import com.example.cc_retrofit_gamesuit.network.ApiClient
import com.example.cc_retrofit_gamesuit.response.PutEditBody
import com.example.cc_retrofit_gamesuit.response.PutEditResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EditEmailPresenter (val listener:Listener){
    interface Listener{
        fun onUpdatePersonSuccess(message: String)
        fun onUpdatePersonFailed(errorMessage: String)
    }

    fun updatePerson(username:String, email: String, id: Int, sharedPreferences: SharedPreferences) {

        val objectPut = PutEditBody(email,username)

        ApiClient.apiService.updatePerson(objectPut,id.toString()).enqueue(object :
            Callback<PutEditResponse> {
            override fun onResponse(
                call: Call<PutEditResponse>,
                response: Response<PutEditResponse>
            ) {
                if(response.isSuccessful) {
//                    disini push data ke shared preference
                    val editor = sharedPreferences.edit()
                    editor.putString(LoginActivity.FIELD_EMAIL, response.body()?.data?.email)

                    val toastStatus = editor.commit()

                    if(toastStatus){
                        listener.onUpdatePersonSuccess("${response.body()?.result}")
                    }else{
                        listener.onUpdatePersonSuccess("${response.body()?.result}")
                    }
                }else {
                    listener.onUpdatePersonFailed("Error : ${response.body()?.result}")
                }
            }

            override fun onFailure(call: Call<PutEditResponse>, t: Throwable) {
                listener.onUpdatePersonFailed(t.toString())
            }

        })
    }
}