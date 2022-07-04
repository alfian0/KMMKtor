package com.example.shared.net.service

import com.example.shared.data.MovieResponse

interface AppServices {
    suspend fun search(): MovieResponse
}