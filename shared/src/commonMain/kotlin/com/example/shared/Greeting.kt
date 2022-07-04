package com.example.shared

import com.example.shared.net.Endpoint
import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

class Greeting {
    private val client = HttpClient() {
        install(ContentNegotiation) {
            json(Json {
                encodeDefaults = true
            })
        }
        install(Logging) {
            level = LogLevel.HEADERS
            logger = object : Logger {
                override fun log(message: String) {
                    Napier.v(tag = "HTTP Client", message = message)
                }
            }
        }
    }.also { initLogger() }

    suspend fun greeting(): String {
        return "${get()}, ${Platform().platform}!"
    }

    private suspend fun get(): String {
        val response: HttpResponse = client.get(Endpoint().movie)
        return response.bodyAsText()
    }
}