package com.example.cc_retrofit_gamesuit.response


import com.google.gson.annotations.SerializedName

data class PostPersonLoginResponse(
    @SerializedName("data")
    val `data`: Data,
    @SerializedName("message")
    val message: String,
    @SerializedName("status")
    val status: Int
) {
    data class Data(
        @SerializedName("email")
        var email: String,
        @SerializedName("id")
        var id: Int,
        @SerializedName("username")
        var username: String
    )
}