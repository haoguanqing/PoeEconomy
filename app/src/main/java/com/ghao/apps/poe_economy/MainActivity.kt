package com.ghao.apps.poe_economy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.ghao.apps.poe_economy.data.PoeEconomyViewModel
import com.ghao.apps.poe_economy.ui.MainNavHost
import com.ghao.apps.poe_economy.theme.MyTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: PoeEconomyViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MainNavHost(
                    modifier = Modifier.fillMaxSize(),
                    viewModel = viewModel,
                    navController = rememberNavController()
                )
            }
        }
    }
}

