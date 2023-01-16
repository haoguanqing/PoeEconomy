package com.ghao.apps.poe_economy.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.graphics.Color

@Composable
@ReadOnlyComposable
fun dynamicColor(light: Color, dark: Color) = if (isSystemInDarkTheme()) dark else light

object DynamicColor {
    /*val primary @Composable @ReadOnlyComposable get() =
        dynamicColor(light = StaticColor.Purple500, dark = StaticColor.Purple200)*/
    /*val onPrimary @Composable @ReadOnlyComposable get() =
        dynamicColor(light = StaticColor.White, dark = StaticColor.White)*/
    val primaryText @Composable @ReadOnlyComposable get() =
        dynamicColor(light = StaticColor.Gray1100, dark = StaticColor.SpaceGray)
    val secondaryText @Composable @ReadOnlyComposable get() =
        dynamicColor(light = StaticColor.Gray700, dark = Color(0xff7c838a))
    val tertiary @Composable @ReadOnlyComposable get() =
        dynamicColor(light = StaticColor.Gray200, dark = Color(0xff2f3336))
    val appBackground @Composable @ReadOnlyComposable get() =
        dynamicColor(light = StaticColor.White, dark = StaticColor.Gray1100)
    val divider @Composable @ReadOnlyComposable get() = tertiary
}

object StaticColor {
    val Blue0 = Color(0xFFEAFAFF)
    val Blue50 = Color(0xFFD7F6FF)
    val Blue100 = Color(0xFFBFF2FF)
    val Blue200 = Color(0xFF97E3FF)
    val Blue300 = Color(0xFF6BC9FB)
    val Blue400 = Color(0xFF43B3F6)
    val Blue500 = Color(0xFF1D9BF0)
    val Blue600 = Color(0xFF0083EB)
    val Blue700 = Color(0xFF006FD6)
    val Blue800 = Color(0xFF005AC2)
    val Blue900 = Color(0xFF003886)
    val Blue1000 = Color(0xFF00154A)
    val Blue1100 = Color(0xFF02113D)

    val Gray0 = Color(0xFFF7F9F9)
    val Gray50 = Color(0xFFEFF3F4)
    val Gray100 = Color(0xFFE5EAEC)
    val Gray200 = Color(0xFFCFD9DE)
    val Gray300 = Color(0xFFB9CAD3)
    val Gray400 = Color(0xFF9FB5C3)
    val Gray500 = Color(0xFF829AAB)
    val Gray600 = Color(0xFF6B7F8E)
    val Gray700 = Color(0xFF536471)
    val Gray800 = Color(0xFF40515E)
    val Gray900 = Color(0xFF37434D)
    val Gray1000 = Color(0xFF242E36)
    val Gray1100 = Color(0xFF0F1419)

    val Green0 = Color(0xFFEDFFF9)
    val Green50 = Color(0xFFDBF8EB)
    val Green100 = Color(0xFFC2F1DC)
    val Green200 = Color(0xFF92E3BF)
    val Green300 = Color(0xFF61D6A3)
    val Green400 = Color(0xFF31C88E)
    val Green500 = Color(0xFF00BA7C)
    val Green600 = Color(0xFF009C64)
    val Green700 = Color(0xFF007E50)
    val Green800 = Color(0xFF00613D)
    val Green900 = Color(0xFF004329)
    val Green1000 = Color(0xFF00251A)
    val Green1100 = Color(0xFF002218)

    val Magenta0 = Color(0xFFFFF1F8)
    val Magenta50 = Color(0xFFFFDDED)
    val Magenta100 = Color(0xFFFEC7E1)
    val Magenta200 = Color(0xFFFD9BC9)
    val Magenta300 = Color(0xFFFB70B0)
    val Magenta400 = Color(0xFFFA4498)
    val Magenta500 = Color(0xFFF91880)
    val Magenta600 = Color(0xFFD4136D)
    val Magenta700 = Color(0xFFAF0E5A)
    val Magenta800 = Color(0xFF890A46)
    val Magenta900 = Color(0xFF640533)
    val Magenta1000 = Color(0xFF3F001F)
    val Magenta1100 = Color(0xFF37011C)

    val Orange0 = Color(0xFFFEF5EC)
    val Orange50 = Color(0xFFFFEDDB)
    val Orange100 = Color(0xFFFFE0C2)
    val Orange200 = Color(0xFFFFC692)
    val Orange300 = Color(0xFFFFAD61)
    val Orange400 = Color(0xFFFF9331)
    val Orange500 = Color(0xFFFF7A00)
    val Orange600 = Color(0xFFD86000)
    val Orange700 = Color(0xFFB04500)
    val Orange800 = Color(0xFF892B00)
    val Orange900 = Color(0xFF692100)
    val Orange1000 = Color(0xFF491600)
    val Orange1100 = Color(0xFF3C1201)

    val Plum0 = Color(0xFFFFEFFF)
    val Plum50 = Color(0xFFFAE0FA)
    val Plum100 = Color(0xFFF4CDF5)
    val Plum200 = Color(0xFFE9A7EB)
    val Plum300 = Color(0xFFDF82E0)
    val Plum400 = Color(0xFFD45CD6)
    val Plum500 = Color(0xFFC936CC)
    val Plum600 = Color(0xFFAB2BAE)
    val Plum700 = Color(0xFF8D2090)
    val Plum800 = Color(0xFF701671)
    val Plum900 = Color(0xFF520B53)
    val Plum1000 = Color(0xFF340035)
    val Plum1100 = Color(0xFF2D032D)

    val Purple0 = Color(0xFFF5F3FF)
    val Purple50 = Color(0xFFECE8FF)
    val Purple100 = Color(0xFFDFD8FF)
    val Purple200 = Color(0xFFC5B7FF)
    val Purple300 = Color(0xFFAC97FF)
    val Purple400 = Color(0xFF9276FF)
    val Purple500 = Color(0xFF7856FF)
    val Purple600 = Color(0xFF6545DB)
    val Purple700 = Color(0xFF5234B7)
    val Purple800 = Color(0xFF3F2292)
    val Purple900 = Color(0xFF2C116E)
    val Purple1000 = Color(0xFF19004A)
    val Purple1100 = Color(0xFF160634)

    val Red0 = Color(0xFFFFF0F1)
    val Red50 = Color(0xFFFEDEE3)
    val Red100 = Color(0xFFFDC9CE)
    val Red200 = Color(0xFFFB9FA8)
    val Red300 = Color(0xFFF87580)
    val Red400 = Color(0xFFF64B5C)
    val Red500 = Color(0xFFF4212E)
    val Red600 = Color(0xFFD11A28)
    val Red700 = Color(0xFFAE1425)
    val Red800 = Color(0xFF8A0D20)
    val Red900 = Color(0xFF67070F)
    val Red1000 = Color(0xFF440004)
    val Red1100 = Color(0xFF3D0105)

    val Teal0 = Color(0xFFE9FEFF)
    val Teal50 = Color(0xFFD1F8FA)
    val Teal100 = Color(0xFFB3F1F4)
    val Teal200 = Color(0xFF78E4E8)
    val Teal300 = Color(0xFF3CD6DD)
    val Teal400 = Color(0xFF00C9D1)
    val Teal500 = Color(0xFF00AFB6)
    val Teal600 = Color(0xFF009399)
    val Teal700 = Color(0xFF00777C)
    val Teal800 = Color(0xFF005A5F)
    val Teal900 = Color(0xFF003E42)
    val Teal1000 = Color(0xFF002225)
    val Teal1100 = Color(0xFF022023)

    val Yellow0 = Color(0xFFFFFDEA)
    val Yellow50 = Color(0xFFFFFED7)
    val Yellow100 = Color(0xFFFFFEC0)
    val Yellow200 = Color(0xFFFFF595)
    val Yellow300 = Color(0xFFFFEB6B)
    val Yellow400 = Color(0xFFFFE042)
    val Yellow500 = Color(0xFFFFD400)
    val Yellow600 = Color(0xFFDCAB00)
    val Yellow700 = Color(0xFFB88200)
    val Yellow800 = Color(0xFF955900)
    val Yellow900 = Color(0xFF6F3E00)
    val Yellow1000 = Color(0xFF482300)
    val Yellow1100 = Color(0xFF3D1E02)

    val White = Color(0xffffffff)
    val Black = Color(0xff000000)
    val Clear = Color(0x00000000)
    val SpaceGray = Color(0xFF959DA5)
    val Error = Color(0xFFB00020)
    val Link = Color(0xff1b95e0)
}
