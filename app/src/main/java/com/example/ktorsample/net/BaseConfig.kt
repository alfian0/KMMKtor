package com.example.ktorsample.net

import android.util.Log
import com.example.ktorsample.data.Movie
import io.ktor.client.call.*
import io.ktor.client.request.*
import io.ktor.http.*
import io.ktor.util.date.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class BaseConfig(endpoint: String) {
    fun headers(block: (HeadersBuilder) -> Unit) {
        headers {
            it.append(HttpHeaders.Accept, "text/html")
            it.append(HttpHeaders.Authorization, "abc123")
            it.append(HttpHeaders.UserAgent, "ktor client")
        }
    }
    var getResponse = GlobalScope.launch {
        val response = Base.getInstance.get(endpoint) {
            headers {
                    headers {
                        append(HttpHeaders.Accept, "text/html")
                        append(HttpHeaders.Authorization, "abc123")
                        append(HttpHeaders.UserAgent, "ktor client")
                    }
            }
                url {
                    protocol = URLProtocol.HTTPS
                    host = "https://api.themoviedb.org"
                    path("docs/welcome.html")
                }
                cookie(
                    name = "user_name", value = "jetbrains", expires = GMTDate(
                        seconds = 0,
                        minutes = 0,
                        hours = 10,
                        dayOfMonth = 1,
                        month = Month.APRIL,
                        year = 2023
                    )
                )
        }
        Log.e("data2", response.body<String>().toString())
    }

}