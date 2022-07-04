package com.example.shared.net.service

import com.example.shared.data.MovieResponse
import com.example.shared.net.Endpoint
import com.example.shared.net.KtorClient
import io.ktor.client.call.*
import io.ktor.client.request.*

object AppServicesImpl : AppServices {
    private val httpClient by lazy { KtorClient.getInstance }

    override suspend fun search(): MovieResponse {
        return httpClient.get(Endpoint().movie).body()
    }
}