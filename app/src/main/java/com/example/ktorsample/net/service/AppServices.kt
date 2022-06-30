package com.example.ktorsample.net.service

import com.example.ktorsample.data.MovieResponse

interface AppServices {
    suspend fun search(
//        term: String = "burger",
//        location: String = "california",
//        limit: Int = 50,
    ): MovieResponse
}