package com.example.shared.net

import com.example.shared.initLogger
import io.github.aakira.napier.Napier
import io.ktor.client.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

object KtorClient {
//    private const val AUTHORIZATION_HEADER = "Authorization"
//    private var API_KEY: String = "Your API Key here"

    private val client = HttpClient() {
//        defaultRequest {
//            header(AUTHORIZATION_HEADER, "BEARER $API_KEY")
//        }
        install(ContentNegotiation) {
            json(Json {
                encodeDefaults = true
//                prettyPrint = true
//                isLenient = true
//                ignoreUnknownKeys = true
                //explicitNulls = false
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

    val getInstance = client
}