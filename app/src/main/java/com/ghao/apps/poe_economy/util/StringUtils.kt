package com.ghao.apps.poe_economy.util

fun Double.getDecimalString(): String {
    val decimal = ((this - this.toInt().toDouble()) * 100).toInt()
    return if (decimal == 0) {
        "00"
    } else if (decimal < 10) {
        "0$decimal"
    } else {
        "$decimal"
    }
}
