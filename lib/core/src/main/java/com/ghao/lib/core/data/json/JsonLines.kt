package com.ghao.lib.core.data.json

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class JsonLines(
    @field:Json val lines: List<JsonItem>
)
