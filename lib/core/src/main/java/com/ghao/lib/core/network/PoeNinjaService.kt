package com.ghao.lib.core.network

import androidx.annotation.StringDef
import com.ghao.lib.core.data.json.JsonCurrencyLines
import com.ghao.lib.core.data.json.JsonLines
import io.reactivex.rxjava3.core.Single
import retrofit2.http.GET
import retrofit2.http.Query

// https://github.com/5k-mirrors/misc-poe-tools/blob/master/doc/poe-ninja-api.md
interface PoeNinjaService {
    @GET("/api/data/currencyoverview")
    suspend fun getCurrency(
        @Query("league") league: String,
        @Query("type") @CurrencyType type: String,
        @Query("language") language: String = "en"
    ): JsonCurrencyLines

    @GET("/api/data/itemoverview")
    suspend fun getItems(
        @Query("league") league: String,
        @Query("type") @ItemType type: String,
        @Query("language") language: String = "en"
    ): JsonLines

    @GET("/api/data/currencyoverview")
    fun getCurrencySingle(
        @Query("league") league: String,
        @Query("type") @ItemType type: String,
        @Query("language") language: String = "en"
    ): Single<JsonCurrencyLines>

    companion object {
        const val POE_NINJA_BASE_URL = "https://poe.ninja/"
    }
}

@Retention(AnnotationRetention.SOURCE)
@StringDef("Currency", "Fragment")
annotation class CurrencyType

@Retention(AnnotationRetention.SOURCE)
@StringDef(
    "Oil",
    "Artifact",
    "Incubator",
    "Scarab",
    "Fossil",
    "Resonator",
    "Essence",
    "DivinationCard",
    "SkillGem",
    "BaseType",
    "HelmetEnchant",
    "UniqueMap",
    "Map",
    "UniqueJewel",
    "UniqueFlask",
    "UniqueWeapon",
    "UniqueArmour",
    "UniqueAccessory",
    "Beast",
    "Vial",
)
annotation class ItemType
