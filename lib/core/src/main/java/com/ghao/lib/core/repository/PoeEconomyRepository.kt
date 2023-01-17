package com.ghao.lib.core.repository

import com.ghao.lib.core.data.Item
import com.ghao.lib.core.data.ItemCategory
import com.ghao.lib.core.data.json.CurrencyDetails
import com.ghao.lib.core.data.json.JsonCurrency
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

interface PoeEconomyRepository {
    fun getCurrency(
        league: String,
        type: ItemCategory,
        externalScope: CoroutineScope
    ): Flow<Result<List<Pair<JsonCurrency, CurrencyDetails>>>>

    fun getItems(
        league: String,
        type: ItemCategory,
        externalScope: CoroutineScope
    ): Flow<Result<List<Item>>>

    fun getCurrencySingle(
        league: String,
        type: ItemCategory
    ): Single<Result<List<Pair<JsonCurrency, CurrencyDetails>>>>
}
