package com.ugurkuyu.otelapp.network

import com.ugurkuyu.otelapp.model.OtelResponse
import com.ugurkuyu.otelapp.model.Result
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET  ("otel.json")
    fun getAllHotels(): Call<OtelResponse>
}