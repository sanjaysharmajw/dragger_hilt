package com.sanjay.practice.Remote
import com.sanjay.practice.Models.UserResponse
import retrofit2.Response
import retrofit2.http.GET

interface UserService {
    @GET("users")
    suspend fun getUsers(): Response<UserResponse>
}
