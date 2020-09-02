package com.example.cc_retrofit_gamesuit.response


import com.google.gson.annotations.SerializedName

data class PostPersonRegisterResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int
) {
    data class Data(
        @SerializedName("email")
        val email: String,
        @SerializedName("id")
        val id: Int,
        @SerializedName("username")
        val username: String
    )
}