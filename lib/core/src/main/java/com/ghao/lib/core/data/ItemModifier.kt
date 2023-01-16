package com.ghao.lib.core.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ItemModifier(
    @field:Json val text: String,
    @field:Json val optional: Boolean
)
