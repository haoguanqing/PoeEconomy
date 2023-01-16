package com.ghao.lib.core.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Transaction(
    @PrimaryKey val id: Long,
    @ColumnInfo(name = "date") val date: String,
    @ColumnInfo(name = "clearing_time") val clearingTime: String,
    @ColumnInfo(name = "amount") val amount: Double,
    @ColumnInfo(name = "merchant_name") val merchantName: String,
    @ColumnInfo(name = "merchant_city") val merchantCity: String,
    @ColumnInfo(name = "merchant_state") val merchantState: String,
    @ColumnInfo(name = "merchant_category") val merchantCategory: String,
    @ColumnInfo(name = "card_last_4") val cardLast4: Short,
    @ColumnInfo(name = "card_display_name") val cardDisplayName: String,
    @ColumnInfo(name = "has_receipt") val hasReceipt: Boolean,
    @ColumnInfo(name = "accounting_sync_date") val accountingSyncDate: String,
    @ColumnInfo(name = "logo_url") val logoUrl: String,
)
