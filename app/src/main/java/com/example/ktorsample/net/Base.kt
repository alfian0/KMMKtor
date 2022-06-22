package com.example.ktorsample.net

import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.plugins.logging.*
import io.ktor.network.tls.*

//use engine CIO,Apache,Java,Jetty,Android,Okhttp
object Base {
    private val client = HttpClient(CIO) {
//        install(Logging) {
//            logger = Logger.DEFAULT
//            level = LogLevel.HEADERS
//        }
        engine {
            //config engine
            maxConnectionsCount = 1000
            endpoint {
                // this: EndpointConfig
                maxConnectionsPerRoute = 100
                pipelineMaxSize = 20
                keepAliveTime = 5000
                connectTimeout = 5000
                connectAttempts = 5
            }
//                https {
//                    // this: TLSConfigBuilder
//                    serverName = "api.ktor.io"
//                    cipherSuites = CIOCipherSuites.SupportedSuites
//                    trustManager = SSLConfig.SslSettings.getTrustManager()
//
//                }
        }

        install(Logging) {
            logger = Logger.DEFAULT
            level = LogLevel.HEADERS
        }
    }
    val getInstance = client
}
