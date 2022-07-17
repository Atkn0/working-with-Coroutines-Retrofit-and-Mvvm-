package com.example.kotlinroom.Service

import com.example.kotlinroom.Model.PhotoModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.http.GET

interface PhotoApi {


    //base url = https://jsonplaceholder.typicode.com/

    @GET("photos")
    suspend fun getData():List<PhotoModel>

}