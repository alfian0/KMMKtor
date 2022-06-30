package com.example.ktorsample.net.service

import android.util.Log
import com.example.ktorsample.data.MovieResponse
import com.example.ktorsample.net.Endpoint
import com.example.ktorsample.net.KtorClient
import io.ktor.client.call.*
import io.ktor.client.request.*

object AppServicesImpl : AppServices {
    private val httpClient by lazy { KtorClient.getInstance }

    override suspend fun search(): MovieResponse {
        val responseData = httpClient.get(Endpoint().movie).body<MovieResponse>()
        Log.e("data",responseData.toString())
        return responseData
//        return httpClient.get {
//            url(Endpoint().movie)
//        }.body()
    }
}