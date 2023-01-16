package com.ghao.lib.core.repository

import com.ghao.lib.core.data.Item
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

interface PoeEconomyRepository {
    suspend fun getCurrency(): Flow<Result<List<Item>>>
    fun getItems(externalScope: CoroutineScope): Flow<Result<List<Item>>>

    fun getItemsSingle(): Single<Result<List<Item>>>
}