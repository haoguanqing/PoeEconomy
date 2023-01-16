package com.ghao.lib.core.db

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import java.util.Date

@ProvidedTypeConverter
class DateTimeConverter {
    @TypeConverter
    fun fromString(value: String?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToString(date: Date?): String? {
        return date?.time?.toString()
    }
}
