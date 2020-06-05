package com.ugurkuyu.otelapp.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ugurkuyu.otelapp.viewmodel.OtelRepository
import com.ugurkuyu.otelapp.model.Hotels

class OtelViewModel : ViewModel() {
    private val repository: OtelRepository by lazy { OtelRepository() }

    fun getAllHotels(): LiveData<List<Hotels>> = repository.getAllHotels()

}