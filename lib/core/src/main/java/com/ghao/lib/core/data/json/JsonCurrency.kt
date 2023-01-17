package com.ghao.lib.core.data.json

import com.ghao.lib.core.data.Sparkline
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class JsonCurrency(
    @field:Json val detailsId: String,
    @field:Json val currencyTypeName: String,
    @field:Json val pay: CurrencyExchange?,
    @field:Json val receive: CurrencyExchange?,
    @field:Json val paySparkLine: Sparkline,
    @field:Json val receiveSparkLine: Sparkline,
    @field:Json val chaosEquivalent: Float,
    @field:Json val lowConfidencePaySparkLine: Sparkline,
    @field:Json val lowConfidenceReceiveSparkLine: Sparkline,
)

@JsonClass(generateAdapter = true)
data class CurrencyExchange(
    val id: Long,
    val league_id: Long,
    val pay_currency_id: Long,
    val get_currency_id: Long,
    val sample_time_utc: String, // e.g. "2023-01-17T01:53:38.8141931Z"
    val count: Long,
    val value: Float,
    val data_point_count: Long,
    val includes_secondary: Boolean,
    val listing_count: Int,
)

@JsonClass(generateAdapter = true)
data class CurrencyDetails(
    val id: Long,
    val icon: String?,
    val name: String, // map to currencyTypeName
    val tradeId: String?
)
