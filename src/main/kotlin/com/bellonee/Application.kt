package com.bellonee

import com.bellonee.DB.DatabaseFactory
import com.bellonee.repository.UserRepository
import com.bellonee.repository.UserRepositoryImpl
import com.bellonee.routes.authRoutes
import com.bellonee.service.UserService
import com.bellonee.service.UserServiceImpl
import io.ktor.serialization.jackson.jackson
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.plugins.contentnegotiation.ContentNegotiation

fun main() {
    embeddedServer(Netty, port = 8080, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    DatabaseFactory.init()
    install(ContentNegotiation){
        jackson()
    }
    val service: UserService = UserServiceImpl()
    val repository: UserRepository = UserRepositoryImpl(service)
    authRoutes(repository)
}
