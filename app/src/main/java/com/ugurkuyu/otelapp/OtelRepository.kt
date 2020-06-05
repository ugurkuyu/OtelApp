package com.ugurkuyu.otelapp

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.ugurkuyu.otelapp.model.Hotels
import com.ugurkuyu.otelapp.model.OtelResponse
import com.ugurkuyu.otelapp.model.Result
import com.ugurkuyu.otelapp.network.ApiClient
import com.ugurkuyu.otelapp.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OtelRepository() {
    private val apiService: ApiService by lazy { ApiClient.getApiService() }

    fun getAllHotels(): LiveData<List<Hotels>> {
        val otelLiveData: MutableLiveData<List<Hotels>> = MutableLiveData()
        apiService.getAllHotels().enqueue(object : Callback<OtelResponse> {
            override fun onFailure(call: Call<OtelResponse>, t: Throwable) {
                Log.e("onError", "Hata Oluştu: " + t.message)
            }

            override fun onResponse(call: Call<OtelResponse>, response: Response<OtelResponse>) {
                otelLiveData.value = response.body()?.result?.offers?.hotels
            }
        })

        return otelLiveData
    }
}