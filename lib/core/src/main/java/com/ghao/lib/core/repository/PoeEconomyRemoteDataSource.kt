package com.ghao.lib.core.repository

import android.util.Log
import com.ghao.lib.core.data.Item
import com.ghao.lib.core.data.ItemCategory
import com.ghao.lib.core.data.League
import com.ghao.lib.core.data.json.CurrencyDetails
import com.ghao.lib.core.data.json.JsonCurrency
import com.ghao.lib.core.network.CurrencyType
import com.ghao.lib.core.network.ItemType
import com.ghao.lib.core.network.PoeApiService
import com.ghao.lib.core.network.PoeNinjaService
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PoeEconomyRemoteDataSource @Inject constructor(
    private val poeNinjaService: PoeNinjaService,
    private val poeApiService: PoeApiService,
) {

    fun getLeague(): Flow<List<League>> {
        return poeApiService.getLeagues()
    }

    fun getCurrency(
        league: String,
        @CurrencyType type: String
    ): Flow<List<Pair<JsonCurrency, CurrencyDetails>>> {
        Log.e("HGQQQ", "PoeEconomyRemoteDataSource#getCurrency()")
        return flow {
            val items = poeNinjaService.getCurrency(league, type)
            emit(items)
            poeNinjaService
                .getCurrency(league, type)
                .let {
                    Log.e("HGQQQ", "finished getCurrency request $it")
                    emit(it)
                }
        }
            .map { lines ->
                val detailsList = lines.currencyDetails
                lines.lines.map { currency ->
                    currency to detailsList.first { it.name == currency.currencyTypeName }
                }
            }
            .flowOn(Dispatchers.IO)
    }

    fun getItems(
        league: String,
        @ItemType type: String
    ): Flow<List<Item>> {
        return flow {
            val items = poeNinjaService.getItems(league, type)
            emit(items)
        }
            .map { lines ->
                lines.lines.map { it.toDbEntity(ItemCategory.fromType(type)) }
            }
            .flowOn(Dispatchers.IO)
    }

    fun getCurrencySingle(
        league: String,
        @ItemType type: String
    ): Single<List<Pair<JsonCurrency, CurrencyDetails>>> {
        return poeNinjaService
            .getCurrencySingle(league, type)
            .map { lines ->
                val detailsList = lines.currencyDetails
                lines.lines.map { currency ->
                    currency to detailsList.first { it.name == currency.currencyTypeName }
                }
            }
    }
}
