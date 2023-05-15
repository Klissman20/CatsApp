package com.example.catsbreeds.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.catsbreeds.databinding.ActivityMainBinding
import com.example.catsbreeds.domain.model.Cat
import com.example.catsbreeds.ui.adapter.CatAdapter
import com.example.catsbreeds.ui.viewmodel.CatsViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val catsViewModel: CatsViewModel by viewModels()

    private var mCatsRecycler: RecyclerView? = null
    private lateinit var mAdapter: CatAdapter

    var mCats = mutableListOf<Cat>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mCatsRecycler = binding.recyclerView

        catsViewModel.onCreate()

        catsViewModel.catModel.observe(this, Observer {
            mCats.addAll(it)
            mAdapter.notifyDataSetChanged()
        })

        catsViewModel.isLoading.observe(this, Observer {
            binding.progressBar.isVisible = it
        })

        initRecyclerView()
    }

    private fun initRecyclerView() {
        mAdapter = CatAdapter(mCats)
        mCatsRecycler!!.layoutManager = LinearLayoutManager(this)   //Vista en forma de grilla
        mCatsRecycler!!.adapter = mAdapter
    }
}