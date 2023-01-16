package com.ghao.apps.poe_economy.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.graphics.Color

@Composable
fun MyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(), // follows system day/night mode
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        materialDarkColors
    } else {
        materialLightColors
    }

    MaterialTheme(
        colors = colors,
        shapes = Shapes,
        typography = MyTypography.default
    ) {
        CompositionLocalProvider(
            LocalContentColor provides DynamicColor.primaryText,
            LocalTextStyle provides MyTypography.default.body1
        ) {
            content()
        }
    }
}

private val materialLightColors = lightColors(
    primary = StaticColor.Gray1100,
    primaryVariant = StaticColor.Gray1100,
    secondary = StaticColor.Teal200,
    background = StaticColor.White,
    surface = StaticColor.White,
    error = StaticColor.Error,
    onPrimary = StaticColor.White,
    onSecondary = StaticColor.White,
    onBackground = StaticColor.Gray1100,
    onSurface = StaticColor.Gray1100,
    onError = StaticColor.White,
)

private val materialDarkColors = darkColors(
    primary = StaticColor.Gray1100,
    primaryVariant = StaticColor.Gray1100,
    secondary = StaticColor.Teal200,
    background = Color.Black, // Color(0x0024292e)
    surface = Color.Black, // Color(0x0024292e)
    onPrimary = StaticColor.White,
    onSecondary = StaticColor.White,
    onBackground = Color(0xFFD9D9D9),
    onSurface = Color(0xFFD9D9D9),
    onError = StaticColor.White,
)
