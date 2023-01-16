package com.ghao.apps.poe_economy.ui

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.ghao.apps.poe_economy.data.PoeEconomyViewModel
import com.ghao.apps.poe_economy.nav.Route
import com.ghao.apps.poe_economy.theme.DynamicColor
import com.ghao.apps.poe_economy.ui.details.DetailsScreen
import com.ghao.apps.poe_economy.ui.main.MainScreen
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Composable
fun MainNavHost(
    modifier: Modifier = Modifier,
    viewModel: PoeEconomyViewModel,
    navController: NavHostController = rememberNavController()
) {
    val systemUiController = rememberSystemUiController()
    val isInDarkTheme = isSystemInDarkTheme()

    systemUiController.setSystemBarsColor(color = DynamicColor.appBackground, !isInDarkTheme)

    NavHost(navController = navController, startDestination = Route.MAIN) {
        // Main screen
        composable(route = Route.MAIN) { MainScreen(modifier, viewModel, navController) }
        // Detailed screen
        composable(
            route = "${Route.TRANSACTION_DETAILS}/{transactionId}",
            arguments = listOf(navArgument("transactionId") { type = NavType.LongType })
        ) { backStackEntry ->
            DetailsScreen(
                modifier = modifier,
                viewModel = viewModel,
                navController = navController,
                transactionId = backStackEntry.arguments!!.getLong("transactionId")
            )
        }
    }
}