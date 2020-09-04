package com.example.cc_retrofit_gamesuit.network

import com.example.cc_retrofit_gamesuit.response.*
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path


interface ApiService {

    //Method Post untuk Login Personsnya
    @POST("api/v1/user/login")
    fun loginPerson(@Body body: PostPersonLoginBody) : Call<PostPersonLoginResponse>

    //Method Post untuk Register Personsnya
    @POST("api/v1/user/register")
    fun registerPerson(@Body body: PostPersonRegisterBody) : Call<PostPersonRegisterResponse>

    @PUT("api/v1/user/{id}")
    fun updatePerson(@Body body: PutEditBody, @Path("id") id: String) : Call<PutEditResponse>
}