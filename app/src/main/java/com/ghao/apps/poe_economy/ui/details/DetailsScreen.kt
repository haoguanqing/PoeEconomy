package com.ghao.apps.poe_economy.ui.details

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.rxjava3.subscribeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavHostController
import com.ghao.apps.poe_economy.R
import com.ghao.apps.poe_economy.data.PoeEconomyViewModel
import com.ghao.apps.poe_economy.theme.DynamicColor
import com.ghao.apps.poe_economy.theme.Icon
import com.ghao.apps.poe_economy.theme.Spacing
import com.ghao.lib.core.repository.Result
import kotlinx.coroutines.launch

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
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
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
        // val items = viewModel.getItems().collectAsState(initial = Result.Loading)
        val items = viewModel.getItemsSingle().subscribeAsState(initial = Result.Loading)

        when (val result = items.value) {
            Result.Loading -> {
                Text(
                    text = "Loading...",
                    style = MaterialTheme.typography.subtitle1
                )
            }

            is Result.Error -> {
                Column {
                    Text(
                        text = "Error",
                        style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Medium)
                    )
                    Text(
                        text = result.e.message ?: "",
                        style = MaterialTheme.typography.body1
                    )
                }
            }

            is Result.Success -> {
                if (result.content == null) {
                    Text(
                        modifier = Modifier.padding(
                            horizontal = Spacing.Space12,
                            vertical = Spacing.Space16
                        ),
                        text = "Transaction $transactionId not found!"
                    )
                } else {
                    // Render transaction details
                    val transaction = result.content
                    LazyColumn(
                        modifier = Modifier.fillMaxSize(),
                        state = listState,
                    ) {

                    }
                }
            }
        }
    }
}
