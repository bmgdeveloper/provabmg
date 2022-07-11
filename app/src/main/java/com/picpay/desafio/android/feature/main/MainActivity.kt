package com.picpay.desafio.android.feature.main

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.picpay.desafio.android.R
import com.picpay.desafio.android.databinding.ActivityMainBinding
import com.picpay.desafio.android.feature.main.adapter.UserListAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private lateinit var adapter: UserListAdapter
    private val viewModel: MainViewModel by viewModel()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = UserListAdapter()
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(this)

        binding.progressBar.visibility = View.VISIBLE


        viewModel.users.observe(this, Observer {
            adapter.users = it ?: listOf()
            binding.progressBar.visibility = View.GONE
        })
        viewModel.errorMessage.observe(this, Observer {
            val message = getString(R.string.error)

            binding.progressBar.visibility = View.GONE
            binding.recyclerView.visibility = View.GONE

            Toast.makeText(this@MainActivity, message, Toast.LENGTH_SHORT)
                .show()
        })

        viewModel.getListUser()

    }
}
