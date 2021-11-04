package br.com.devspoint.bitcoindataprovider.config.router

import br.com.devspoint.bitcoindataprovider.handler.BitcoinDataProviderHandler
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.server.router

@Configuration
class ServerRouter(
    private val bitcoinDataProviderHandler: BitcoinDataProviderHandler
) {

    @Bean
    fun bitcoinDataProviderRoute() =
        router {
            (
                GET("/bitcoin/history", bitcoinDataProviderHandler::handle)
            )
        }
}