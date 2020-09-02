package com.example.cc_retrofit_gamesuit.response


import com.google.gson.annotations.SerializedName

data class PostPersonLoginBody(
    @SerializedName("email")
    val email: String,
    @SerializedName("password")
    val password: String
)