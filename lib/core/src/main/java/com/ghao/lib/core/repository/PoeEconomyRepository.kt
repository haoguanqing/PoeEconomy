package com.ghao.lib.core.repository

import com.ghao.lib.core.data.Item
import com.ghao.lib.core.data.ItemCategory
import com.ghao.lib.core.network.ItemType
import io.reactivex.rxjava3.core.Single
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.Flow

interface PoeEconomyRepository {
    fun getCurrency(
        league: String,
        type: ItemCategory,
        externalScope: CoroutineScope
    ): Flow<Result<List<Item>>>

    fun getItems(
        league: String,
        type: ItemCategory,
        externalScope: CoroutineScope
    ): Flow<Result<List<Item>>>
}