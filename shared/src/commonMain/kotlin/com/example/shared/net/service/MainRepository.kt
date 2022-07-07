package com.example.shared.net.service

import com.example.shared.data.MovieResponse
import io.ktor.client.plugins.*
import io.ktor.utils.io.errors.*

object MainRepository {
    @Throws(Exception::class)
    suspend fun search():
            List<MovieResponse.ProductionCompany> {
        return try {
            val response = AppServicesImpl.search()
            response.production_companies
        } catch (e: ClientRequestException) {
            emptyList()
        } catch (e: IOException) {
            emptyList()
        }
    }
}