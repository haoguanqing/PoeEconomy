package com.ghao.lib.core.repository

import com.facebook.flipper.plugins.uidebugger.LogTag
import com.ghao.lib.core.data.Item
import com.ghao.lib.core.data.ItemCategory
import com.ghao.lib.core.data.json.CurrencyDetails
import com.ghao.lib.core.data.json.JsonCurrency
import com.ghao.lib.core.db.PoeEconomyDatabase
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.shareIn
import java.util.Collections
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PoeEconomyRepositoryImpl @Inject constructor(
    private val remoteDataSource: PoeEconomyRemoteDataSource,
    private val localDatabase: PoeEconomyDatabase
) : PoeEconomyRepository {

    private val cache: MutableMap<Pair<String, String>, List<Item>> =
        Collections.synchronizedMap(mutableMapOf())
    private val currencyCache: MutableMap<Pair<String, String>, List<Pair<JsonCurrency, CurrencyDetails>>> =
        Collections.synchronizedMap(mutableMapOf())

    override fun getCurrency(
        league: String,
        type: ItemCategory,
        externalScope: CoroutineScope
    ): Flow<Result<List<Pair<JsonCurrency, CurrencyDetails>>>> {
        val key = league to type.name
        if (currencyCache.containsKey(key)) {
            return flowOf(Result.Success(currencyCache[key]!!))
                .shareIn(
                    externalScope,
                    replay = 1,
                    started = SharingStarted.WhileSubscribed()
                )
        }
        return remoteDataSource
            .getCurrency(league, type.name)
            .map {
                currencyCache.remove(key)
                currencyCache[key] = it
                Result.Success(it)
            }
            .catch { Result.Error(it) }
            .onStart<Result<List<Pair<JsonCurrency, CurrencyDetails>>>> { emit(Result.Loading) }
            .shareIn(
                externalScope,
                replay = 1,
                started = SharingStarted.WhileSubscribed()
            )
    }

    override fun getItems(
        league: String,
        type: ItemCategory,
        externalScope: CoroutineScope
    ): Flow<Result<List<Item>>> {
        val key = league to type.name
        if (cache.containsKey(key)) {
            return flowOf(Result.Success(cache[key]!!))
                .shareIn(
                    externalScope,
                    replay = 1,
                    started = SharingStarted.WhileSubscribed()
                )
        }
        return remoteDataSource
            .getItems(league, type.name)
            .map {
                cache.remove(key)
                cache[key] = it
                Result.Success(it)
            }
            .catch { Result.Error(it) }
            .onStart<Result<List<Item>>> { emit(Result.Loading) }
            .shareIn(
                externalScope,
                replay = 1,
                started = SharingStarted.WhileSubscribed()
            )
    }

    override fun getCurrencySingle(
        league: String,
        type: ItemCategory,
    ): Single<Result<List<Pair<JsonCurrency, CurrencyDetails>>>> {
        val key = league to type.name
        if (currencyCache.containsKey(key)) {
            return Single.just(Result.Success(currencyCache[key]!!))
        }
        return remoteDataSource
            .getCurrencySingle(league, type.name)
            .map<Result<List<Pair<JsonCurrency, CurrencyDetails>>>> {
                currencyCache[key] = it
                Result.Success(it)
            }
            .onErrorReturn { Result.Error(it) }
    }
}
