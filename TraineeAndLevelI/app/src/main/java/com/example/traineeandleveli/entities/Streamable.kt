package com.example.traineeandleveli.entities


import com.google.gson.annotations.SerializedName

data class Streamable(
    @SerializedName("fulltrack")
    val fulltrack: String,
    @SerializedName("#text")
    val text: String
)