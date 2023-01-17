package com.ghao.lib.core.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Item(
    @PrimaryKey val detailsId: String,
    @ColumnInfo val name: String,
    @ColumnInfo val itemCategory: ItemCategory,
    @ColumnInfo val id: Long,
    @ColumnInfo val icon: String,
    @ColumnInfo val baseType: String,
    @ColumnInfo val itemClass: Short,
    @ColumnInfo val levelRequired: Short?,
    @ColumnInfo val links: Short?,
    @ColumnInfo val sparkline: Sparkline,
    @ColumnInfo val lowConfidenceSparkline: Sparkline,
    @ColumnInfo val implicitModifiers: List<ItemModifier>,
    @ColumnInfo val explicitModifiers: List<ItemModifier>,
    @ColumnInfo val flavourText: String,
    @ColumnInfo val itemType: String?,
    @ColumnInfo val chaosValue: Float,
    @ColumnInfo val exaltedValue: Float,
    @ColumnInfo val divineValue: Float,
    @ColumnInfo val count: Long,
    @ColumnInfo val listingCount: Long,
    @ColumnInfo val mapTier: Short?,
    @ColumnInfo val variant: String?,
    @ColumnInfo val stackSize: Int?,
    @ColumnInfo val corrupted: Boolean?,
    @ColumnInfo val gemLevel: Short?,
    @ColumnInfo val gemQuality: Short?,
)
