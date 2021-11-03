package br.com.devspoint.bitcoindataprovider.handler

import br.com.devspoint.bitcoindataprovider.model.BitCoinHistory
import org.springframework.http.MediaType
import org.springframework.stereotype.Service
import org.springframework.web.reactive.function.client.WebClient
import org.springframework.web.reactive.function.client.bodyToFlux
import org.springframework.web.reactive.function.client.bodyToMono
import org.springframework.web.reactive.function.server.ServerRequest
import org.springframework.web.reactive.function.server.ServerResponse
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class BitcoinDataProviderHandler(
    private val webClient: WebClient
) {

    fun getData(serverRequest: ServerRequest) =
        ServerResponse.ok()
            .contentType(MediaType.TEXT_EVENT_STREAM)
            .body(getHistory(), BitCoinHistory::class.java)
            .doOnNext { println("Oi") }

    private fun getHistory(): Flux<BitCoinHistory> =
         webClient
            .get()
            .uri("/bitcoin/history")
            .retrieve()
            .bodyToFlux<BitCoinHistory>()

}