package com.bellonee.repository

import com.bellonee.service.CreateUserParams
import com.bellonee.service.UserService
import com.bellonee.utils.BaseResponse

class UserRepositoryImpl  (
    private  val userService: UserService
): UserRepository {
    override suspend fun registerUser(params: CreateUserParams): BaseResponse<Any> {
       return if(isEmailExist(params.email)){
            BaseResponse.ErrorResponse("Email already exist")
        } else{
            val user = userService.registerUser(params)
           if (user != null) {
               BaseResponse.SuccessResponse(data = user, "User register successfully")
           } else{
               BaseResponse.ErrorResponse()
           }
       }
    }

    override suspend fun loginUser(email: String, password: String): BaseResponse<Any> {
        TODO("Not yet implemented")
    }

    private suspend fun isEmailExist(email: String):Boolean{
        return userService.findUserByEmail(email) != null
    }
}