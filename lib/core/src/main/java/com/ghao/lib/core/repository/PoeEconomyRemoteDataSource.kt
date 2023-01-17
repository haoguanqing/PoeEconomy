package com.ghao.lib.core.repository

import com.ghao.lib.core.data.Item
import com.ghao.lib.core.data.ItemCategory
import com.ghao.lib.core.data.League
import com.ghao.lib.core.network.CurrencyType
import com.ghao.lib.core.network.ItemType
import com.ghao.lib.core.network.PoeApiService
import com.ghao.lib.core.network.PoeNinjaService
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
    ): Flow<List<Item>> {
        return flow {
            poeNinjaService
                .getCurrency(league, type)
                .let { emit(it) }
        }
            .map { lines ->
                lines.lines.map { it.toDbEntity(ItemCategory.fromType(type)) }
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

    /*fun getItemsSingle(
        league: String,
        @ItemType type: String
    ): Single<List<Item>> {
        return poeNinjaService
            .getItemsSingle(league, type)
            .map { lines ->
                lines.lines.map { it.toDbEntity(ItemCategory.fromType(type)) }
            }
    }*/
}
