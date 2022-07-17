package com.example.kotlinroom.Model

import com.google.gson.annotations.SerializedName



data class PhotoModel(

    @SerializedName("id")
    val photoId: Int,
    val title:String,
    @SerializedName("url")
    val url:String

)
