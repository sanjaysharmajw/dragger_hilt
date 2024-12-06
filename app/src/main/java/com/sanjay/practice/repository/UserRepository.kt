package com.sanjay.practice.repository

import com.sanjay.practice.Remote.UserService
import javax.inject.Inject


class UserRepository @Inject constructor(private val userService: UserService) {
    suspend fun fetchUsers() = userService.getUsers()
}
