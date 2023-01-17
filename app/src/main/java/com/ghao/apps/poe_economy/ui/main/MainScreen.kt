package com.ghao.apps.poe_economy.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.ghao.apps.poe_economy.R
import com.ghao.apps.poe_economy.data.PoeEconomyViewModel
import com.ghao.apps.poe_economy.theme.DynamicColor
import com.ghao.apps.poe_economy.theme.Icon
import com.ghao.apps.poe_economy.theme.Spacer
import com.ghao.apps.poe_economy.theme.Spacing
import com.ghao.lib.core.data.ItemCategory
import com.ghao.lib.core.repository.Result
import kotlinx.coroutines.launch

// import androidx.compose.runtime.getValue
// import androidx.compose.runtime.setValue

@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    viewModel: PoeEconomyViewModel,
    navController: NavHostController
) {
    val scaffoldState = rememberScaffoldState()
    val listState = rememberLazyListState()
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = modifier,
        scaffoldState = scaffoldState,
        topBar = {
            TopAppBar(
                modifier = Modifier.clickable {
                    scope.launch {
                        listState.animateScrollToItem(0)
                    }
                },
                navigationIcon = {
                    IconButton(onClick = {}) {
                        Icon.Menu()
                    }
                },
                title = {
                    Text(
                        text = stringResource(id = R.string.app_name),
                    )
                },
                backgroundColor = DynamicColor.appBackground,
            )
        },
        content = { paddingValues ->
            MainContent(
                modifier = Modifier
                    .padding(paddingValues)
                    .fillMaxSize(),
                viewModel = viewModel,
                listState = listState,
                navController = navController
            )
        }
    )
}

@OptIn(ExperimentalLifecycleComposeApi::class)
@Composable
fun MainContent(
    modifier: Modifier = Modifier,
    viewModel: PoeEconomyViewModel,
    listState: LazyListState,
    navController: NavController
) {
    // viewModel.getItems("Sanctum", ItemCategory.UniqueAccessory)
    viewModel.getCurrency("Sanctum", ItemCategory.Currency)

    Box(modifier = modifier) {
        val items = viewModel.currency.collectAsStateWithLifecycle()
        /*val items = viewModel
            .getCurrencySingle("Sanctum", ItemCategory.Currency)
            .subscribeAsState(initial = Result.Loading)*/

        when (val result = items.value) {
            Result.Loading -> {
                Box {
                    CircularProgressIndicator(
                        modifier = Modifier
                            .wrapContentSize()
                            .align(alignment = Alignment.Center)
                    )
                }
            }

            is Result.Error -> {
                Column(
                    modifier = Modifier
                        .wrapContentSize()
                        .align(Alignment.Center)
                ) {
                    Text(
                        text = "Error",
                        style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Bold)
                    )
                    Spacer(space = Spacing.Space8)
                    Text(
                        text = result.e.message ?: "",
                        style = MaterialTheme.typography.body1
                    )
                    Spacer(space = Spacing.Space16)
                }
            }

            is Result.Success -> {
                /*MainItemList(
                    modifier = Modifier.fillMaxSize(),
                    listState = listState,
                    items = result.content
                )*/

                MainCurrencyList(
                    modifier = Modifier.fillMaxSize(),
                    listState = listState,
                    items = result.content
                )
            }
        }
    }
}
