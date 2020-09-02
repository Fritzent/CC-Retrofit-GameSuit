package com.example.cc_retrofit_gamesuit.network

import com.example.cc_retrofit_gamesuit.response.PostPersonLoginBody
import com.example.cc_retrofit_gamesuit.response.PostPersonLoginResponse
import com.example.cc_retrofit_gamesuit.response.PostPersonRegisterBody
import com.example.cc_retrofit_gamesuit.response.PostPersonRegisterResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST


interface ApiService {

    //Method Post untuk Login Personsnya
    @POST("api/v1/user/login")
    fun loginPerson(@Body body: PostPersonLoginBody) : Call<PostPersonLoginResponse>

    //Method Post untuk Register Personsnya
    @POST("api/v1/user/register")
    fun registerPerson(@Body body: PostPersonRegisterBody) : Call<PostPersonRegisterResponse>
}