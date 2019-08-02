package com.example.maththeory.retrofit

import com.example.maththeory.model.FetchData
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

internal interface FetchService {

    @GET("/api/theories")
    fun getData(): Call<ArrayList<FetchData>>

    companion object Factory {
        val BASE_URL = "http://192.168.1.11:8000"
        fun create(): FetchService {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
            return retrofit.create(FetchService::class.java)
        }
    }
}