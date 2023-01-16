package com.ghao.lib.core.data.json

import com.ghao.lib.core.data.Transaction
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import com.squareup.moshi.JsonDataException
import java.util.Locale

@JsonClass(generateAdapter = true)
data class JsonTransaction(
    @field:Json(name = "id") val id: Long,
    @field:Json(name = "date") val date: String,
    @field:Json(name = "clearing_time") val clearingTime: String,
    @field:Json(name = "amount") val amount: Double,
    @field:Json(name = "merchant_name") val merchantName: String,
    @field:Json(name = "merchant_city") val merchantCity: String,
    @field:Json(name = "merchant_state") val merchantState: String,
    @field:Json(name = "merchant_category") val merchantCategory: String,
    @field:Json(name = "card_last_4") val cardLast4: Short,
    @field:Json(name = "card_display_name") val cardDisplayName: String,
    @field:Json(name = "has_receipt") val hasReceiptStr: String,
    @field:Json(name = "accounting_sync_date") val accountingSyncDate: String,
    @field:Json(name = "logo_url") val logoUrl: String,
) {
    fun toDbEntity(): Transaction {
        return Transaction(
            id,
            date,
            clearingTime,
            amount,
            merchantName,
            merchantCity,
            merchantState,
            merchantCategory,
            cardLast4,
            cardDisplayName,
            toBoolean(hasReceiptStr),
            accountingSyncDate,
            logoUrl,
        )
    }
}

internal fun toBoolean(yesNo: String): Boolean {
    return when (yesNo.lowercase(Locale.ENGLISH)) {
        "yes" -> true
        "no" -> false
        else -> throw JsonDataException("Field cannot be converted to boolean: $yesNo")
    }
}