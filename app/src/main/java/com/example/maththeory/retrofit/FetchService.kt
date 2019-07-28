package com.example.maththeory.retrofit

import com.example.maththeory.model.FetchData
import retrofit2.Call
import retrofit2.http.GET

internal interface FetchService {

    @GET("/api/theories")
    fun getData(): Call<FetchData>
}
