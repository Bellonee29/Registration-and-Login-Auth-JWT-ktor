package com.bellonee.repository

import com.bellonee.service.CreateUserParams
import com.bellonee.utils.BaseResponse

interface UserRepository {
    suspend fun registerUser(params: CreateUserParams): BaseResponse<Any>
    suspend fun loginUser(email: String, password: String): BaseResponse<Any>
}