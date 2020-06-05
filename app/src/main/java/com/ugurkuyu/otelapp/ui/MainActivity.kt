package com.ugurkuyu.otelapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ugurkuyu.otelapp.OtelAdapter
import com.ugurkuyu.otelapp.R
import com.ugurkuyu.otelapp.viewmodel.OtelViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var adapter: OtelAdapter
    private lateinit var viewModel: OtelViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProvider(this).get(OtelViewModel::class.java)

        adapter = OtelAdapter()
        main_recyclerview.layoutManager = LinearLayoutManager(this)

        viewModel.getAllHotels().observe(this, Observer {
            adapter.submitList(it)
            main_recyclerview.adapter = adapter
        })
    }
}