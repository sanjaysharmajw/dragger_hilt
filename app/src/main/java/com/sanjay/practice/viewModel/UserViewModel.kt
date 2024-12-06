package com.sanjay.practice.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.sanjay.practice.Models.User
import com.sanjay.practice.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(private val repository: UserRepository) : ViewModel() {
    private val _users = MutableLiveData<List<User>>()
    val users: LiveData<List<User>> get() = _users
    fun getUsers() {
        viewModelScope.launch {
            try {
                val response = repository.fetchUsers()
                if (response.isSuccessful) {
                    _users.postValue(response.body()?.data ?: emptyList())
                } else {
                    _users.postValue(emptyList())
                }
            } catch (e: Exception) {
                _users.postValue(emptyList())
            }
        }
    }
}
