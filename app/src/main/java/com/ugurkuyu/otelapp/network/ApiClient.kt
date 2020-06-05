package com.ugurkuyu.otelapp.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {
    fun getApiService(): ApiService {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://www.ipucubilisim.com.tr/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(ApiService::class.java)
    }
}