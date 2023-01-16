package com.ghao.apps.poe_economy.theme

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

object Spacing {
    val Space1 = 1.dp
    val Space2 = 2.dp
    val Space4 = 4.dp
    val Space8 = 8.dp
    val Space12 = 12.dp
    val Space16 = 16.dp
    val Space20 = 20.dp
    val Space24 = 24.dp
    val Space28 = 28.dp
    val Space32 = 32.dp
    val Space36 = 36.dp
    val Space40 = 40.dp
    val Space48 = 48.dp
    val Space56 = 56.dp
    val Space64 = 64.dp
    val Space72 = 72.dp
}

@Composable
fun Spacer(space: Dp) {
    Spacer(modifier = Modifier.size(space))
}

@Composable
fun FillWidth() {
    Spacer(modifier = Modifier.fillMaxWidth())
}