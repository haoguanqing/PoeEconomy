package com.ghao.lib.core.data.json

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class JsonLines(
    @field:Json val lines: List<JsonItem>,
    @field:Json val language: Language,
)

@JsonClass(generateAdapter = true)
data class JsonCurrencyLines(
    @field:Json val lines: List<JsonCurrency>,
    @field:Json val currencyDetails: List<CurrencyDetails>,
    @field:Json val language: Language,
)

@JsonClass(generateAdapter = true)
data class Language(
    val name: String,
    // val translations: Any
)
