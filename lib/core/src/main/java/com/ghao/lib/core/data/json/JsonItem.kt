package com.ghao.lib.core.data.json

import com.ghao.lib.core.data.ItemCategory
import com.ghao.lib.core.data.ItemModifier
import com.ghao.lib.core.data.Item
import com.ghao.lib.core.data.Sparkline
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class JsonItem(
    @field:Json val detailsId: String,
    @field:Json val name: String,
    @field:Json val id: Long,
    @field:Json val icon: String,
    @field:Json val levelRequired: Short?,
    @field:Json val baseType: String,
    @field:Json val links: Short?,
    @field:Json val itemClass: Short,
    @field:Json val sparkline: Sparkline,
    @field:Json val lowConfidenceSparkline: Sparkline,
    @field:Json val implicitModifiers: List<ItemModifier>,
    @field:Json val explicitModifiers: List<ItemModifier>,
    @field:Json val flavourText: String,
    @field:Json val itemType: String?,
    @field:Json val chaosValue: Float,
    @field:Json val exaltedValue: Float,
    @field:Json val divineValue: Float,
    @field:Json val count: Long,
    @field:Json val listingCount: Long,
    @field:Json val mapTier: Short?, // map
    @field:Json val variant: String?, // map=", gen-16", gem="21/23c", enchant="20"
    @field:Json val stackSize: Int?, // oil
    @field:Json val corrupted: Boolean?, // gem
    @field:Json val gemLevel: Short?, // gem
    @field:Json val gemQuality: Short?, // gem
    // @field:Json val tradeInfo: TradeInfo?, // enchant
) {

    fun toDbEntity(itemCategory: ItemCategory): Item {
        return Item(
            detailsId,
            name,
            itemCategory,
            id,
            icon,
            baseType,
            itemClass,
            levelRequired,
            links,
            sparkline,
            lowConfidenceSparkline,
            implicitModifiers,
            explicitModifiers,
            flavourText,
            itemType,
            chaosValue,
            exaltedValue,
            divineValue,
            count,
            listingCount,
            mapTier,
            variant,
            stackSize,
            corrupted,
            gemLevel,
            gemQuality,
        )
    }
}