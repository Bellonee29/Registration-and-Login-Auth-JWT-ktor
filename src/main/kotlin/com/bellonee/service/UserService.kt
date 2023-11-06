package com.bellonee.service

import com.bellonee.model.User

interface UserService {
    suspend fun registerUser(params: CreateUserParams): User?
    suspend fun findUserByEmail(email:String): User?
}