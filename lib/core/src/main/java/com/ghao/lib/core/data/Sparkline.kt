package com.ghao.lib.core.data

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Sparkline(
    @field:Json val data: List<Float>,
    @field:Json val totalChange: Float
)
