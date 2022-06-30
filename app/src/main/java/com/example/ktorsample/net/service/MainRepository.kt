package com.example.ktorsample.net.service

import android.util.Log
import com.example.ktorsample.data.MovieResponse
import io.ktor.client.plugins.*
import timber.log.Timber
import java.io.IOException

object MainRepository {

    suspend fun search():
            List<MovieResponse.ProductionCompany> {
        return try {
            //val response = YelpAppServicesImpl.search(term = term ?: "")
            val response = AppServicesImpl.search()
            Log.e("data",response.toString())
            response.production_companies
        } catch (e: ClientRequestException) {
            Timber.d("client exception" )
            emptyList()
        } catch (e: IOException) {
            Timber.d("no internet" )
            emptyList()
        }
    }
}