package br.com.devspoint.bitcoindataprovider.model

import java.math.BigDecimal

data class BitCoinHistory (
    val id: String,
    val order: Int,
    val openingValue: BigDecimal,
    val date: String
)