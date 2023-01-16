package com.ghao.lib.core.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class League(
    @PrimaryKey val id: String,
    @ColumnInfo val realm: String,
    @ColumnInfo val url: String,
    @ColumnInfo val startAt: String,
    @ColumnInfo val endAt: String,
    @ColumnInfo val description: String,
    @ColumnInfo val registerAt: String,
    @ColumnInfo val delveEvent: Boolean,
)
