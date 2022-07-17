package com.example.kotlinroom.ViewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.kotlinroom.Model.PhotoModel
import com.example.kotlinroom.Service.PhotoApiService
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import retrofit2.*

class HomeViewModel : ViewModel() {

    private var liveDataList: MutableLiveData<List<PhotoModel>> = MutableLiveData()


    private val apiService = PhotoApiService()


    fun returnPhotoModelList(): MutableLiveData<List<PhotoModel>> {

        return liveDataList

    }




    suspend fun getDataFromApi() {

            val myList = apiService.getDataService()
            liveDataList.postValue(myList)


    }




}