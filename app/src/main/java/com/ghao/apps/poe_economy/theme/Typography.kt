package com.ghao.apps.poe_economy.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object MyTypography {
    val default = Typography(
        subtitle1 = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 20.sp,
        ),
        subtitle2 = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 17.sp,
        ),
        body1 = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 15.sp,
        ),
        body2 = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 13.sp,
            letterSpacing = (-0.1).sp
        ),
        button = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 13.sp,
            letterSpacing = 0.25.sp
        ),
        caption = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 11.sp,
            letterSpacing = 0.1.sp
        )
    )
}
