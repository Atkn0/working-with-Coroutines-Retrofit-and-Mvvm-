package com.example.kotlinroom.Service

import com.example.kotlinroom.Model.PhotoModel
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PhotoApiService {

    private val BASE_URL:String = "https://jsonplaceholder.typicode.com/"


    val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    val api = retrofit.create(PhotoApi::class.java)


    suspend fun getDataService():List<PhotoModel>{
        return api.getData()
    }


}