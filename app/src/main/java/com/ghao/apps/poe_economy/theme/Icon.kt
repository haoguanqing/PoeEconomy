package com.ghao.apps.poe_economy.theme

import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.ghao.apps.poe_economy.R

object Icon {
    @Composable
    fun Menu(modifier: Modifier = Modifier, contentDescription: String? = null) {
        Icon(
            modifier = modifier,
            painter = painterResource(id = R.drawable.ic_menu),
            contentDescription = contentDescription
        )
    }
    @Composable
    fun ArrowLeft(modifier: Modifier = Modifier, contentDescription: String? = null) {
        Icon(
            modifier = modifier,
            painter = painterResource(id = R.drawable.ic_arrow_left),
            contentDescription = contentDescription
        )
    }
}