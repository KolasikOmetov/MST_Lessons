package com.nodj.readmelater

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.nodj.readmelater.data.api.ApiHelper
import com.nodj.readmelater.data.api.RetrofitBuilder
import com.nodj.readmelater.data.model.Page
import com.nodj.readmelater.ui.base.ViewModelFactory
import com.nodj.readmelater.ui.main.adapter.MainAdapter
import com.nodj.readmelater.ui.main.viewmodel.MainViewModel
import com.nodj.readmelater.utils.Status.SUCCESS
import com.nodj.readmelater.utils.Status.LOADING
import com.nodj.readmelater.utils.Status.ERROR
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: MainViewModel
    private lateinit var adapter: MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
        setupUI()
        setupObservers()
    }


    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, ViewModelFactory(
            ApiHelper(
                RetrofitBuilder.apiService))).get(MainViewModel::class.java)
    }

    private fun setupUI() {
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = MainAdapter(arrayListOf())
        recyclerView.addItemDecoration(
            DividerItemDecoration(
                recyclerView.context,
                (recyclerView.layoutManager as LinearLayoutManager).orientation
            )
        )
        recyclerView.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.getPages().observe(this, Observer {
            it?.let { resource ->
                when (resource.status) {
                    SUCCESS -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        resource.data?.let { users -> retrieveList(users) }
                    }
                    ERROR -> {
                        recyclerView.visibility = View.VISIBLE
                        progressBar.visibility = View.GONE
                        Toast.makeText(this, it.message, Toast.LENGTH_LONG).show()
                    }
                    LOADING -> {
                        progressBar.visibility = View.VISIBLE
                        recyclerView.visibility = View.GONE
                    }
                }
            }
        })
    }

    private fun retrieveList(pages: List<Page>) {
        adapter.apply {
            addPages(pages)
            notifyDataSetChanged()
        }
    }
}