package com.lid.recycleviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.lid.recycleviewtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    private val viewModel by viewModels<MainViewModel> {
        MainViewModelFactory()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        viewModel.itemList.observe(this, {
            it?.let {
                binding.recyclerView.adapter = ItemRecyclerAdapter(viewModel, it)
            }
        })

        setContentView(binding.root)

    }
}