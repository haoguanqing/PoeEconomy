package com.ghao.apps.poe_economy.ui.details

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import com.ghao.apps.poe_economy.R
import com.ghao.apps.poe_economy.data.PoeEconomyViewModel
import com.ghao.apps.poe_economy.theme.DynamicColor
import com.ghao.apps.poe_economy.theme.Icon

@Composable
fun DetailsScreen(
    modifier: Modifier = Modifier,
    viewModel: PoeEconomyViewModel,
    navController: NavHostController,
    transactionId: Long
) {
    val scaffoldState = rememberScaffoldState()
    val listState = rememberLazyListState()

    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon.ArrowLeft(
                            contentDescription = stringResource(id = R.string.button_back)
                        )
                    }
                },
                title = {
                    Text(
                        text = stringResource(id = R.string.title_transaction_details),
                    )
                },
                backgroundColor = DynamicColor.appBackground,
            )
        },
        content = { paddingValues ->
            DetailsContent(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                viewModel = viewModel,
                listState = listState,
                transactionId = transactionId,
            )
        }
    )
}

@Composable
fun DetailsContent(
    modifier: Modifier = Modifier,
    viewModel: PoeEconomyViewModel,
    listState: LazyListState,
    transactionId: Long
) {
    Surface(modifier = modifier) {
    }
}
