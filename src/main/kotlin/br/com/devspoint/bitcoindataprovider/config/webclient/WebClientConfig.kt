package br.com.devspoint.bitcoindataprovider.config.webclient

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class WebClientConfig {

    @Bean
    fun webClientFactory(): WebClient = WebClient.builder()
        .baseUrl("http://localhost:8080")
        .build()
}