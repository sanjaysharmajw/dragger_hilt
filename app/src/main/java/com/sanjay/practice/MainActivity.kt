package com.sanjay.practice

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.sanjay.practice.Adapter.OnItemClickListener
import com.sanjay.practice.Adapter.UserAdapter
import com.sanjay.practice.Utils.Utilities.showToast
import com.sanjay.practice.databinding.ActivityMainBinding
import com.sanjay.practice.viewModel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: UserViewModel by viewModels()
    private lateinit var adapter: UserAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        adapter = UserAdapter(mutableListOf(), object : OnItemClickListener {
            override fun onItemClick(position: Int) {
                val selectedUser = adapter.users[position]
                this@MainActivity.showToast("Clicked: ${selectedUser.first_name} ${selectedUser.last_name}")
            }
        })
        viewModel.getUsers()
        binding.recyclerView.adapter = adapter
        viewModel.users.observe(this) { users -> adapter.updateData(users) }
    }
}