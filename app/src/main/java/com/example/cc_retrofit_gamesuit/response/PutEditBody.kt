package com.example.cc_retrofit_gamesuit.response


import com.google.gson.annotations.SerializedName

data class PutEditBody(
    @SerializedName("email")
    val email: String,
    @SerializedName("username")
    val username: String
)