package com.ghao.apps.poe_economy.ui.main

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.Orientation
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Divider
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.ExperimentalLifecycleComposeApi
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.ghao.apps.poe_economy.R
import com.ghao.apps.poe_economy.data.PoeEconomyViewModel
import com.ghao.apps.poe_economy.theme.DynamicColor
import com.ghao.apps.poe_economy.theme.Icon
import com.ghao.apps.poe_economy.theme.Spacing
import com.ghao.apps.poe_economy.util.toDp
import com.ghao.lib.core.data.ItemCategory
import com.ghao.lib.core.repository.Result
import kotlinx.coroutines.launch
import kotlin.math.roundToInt

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
    viewModel.getItems("Sanctum", ItemCategory.UniqueAccessory)

    Box(modifier = modifier) {
        val items = viewModel.items.collectAsStateWithLifecycle()

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
                MainItemList(
                    modifier = Modifier.fillMaxSize(),
                    listState = listState,
                    items = result.content
                )
            }
        }
    }
}
