package com.ghao.lib.core.data

data class Currency(
    val id: Long,
    val icon: String,
    val name: String, // map to currencyTypeName
    val tradeId: String?
)
