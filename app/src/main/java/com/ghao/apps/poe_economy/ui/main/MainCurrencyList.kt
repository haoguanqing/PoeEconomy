package com.ghao.apps.poe_economy.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import com.ghao.apps.poe_economy.theme.DynamicColor
import com.ghao.apps.poe_economy.theme.Spacing
import com.ghao.lib.core.data.json.CurrencyDetails
import com.ghao.lib.core.data.json.JsonCurrency

@Composable
fun BoxScope.MainCurrencyList(
    modifier: Modifier,
    listState: LazyListState,
    items: List<Pair<JsonCurrency, CurrencyDetails>>
) {
    var changeTextWidth by remember { mutableStateOf(0) }
    var headerHeight by remember { mutableStateOf(0f) }
    var scrollDelta by remember { mutableStateOf(0f) }

    val nestedScrollConnection = remember {
        object : NestedScrollConnection {
            override fun onPostScroll(
                consumed: Offset,
                available: Offset,
                source: NestedScrollSource
            ): Offset {
                scrollDelta += consumed.y
                scrollDelta = scrollDelta.coerceIn(-headerHeight, 0f)
                return super.onPostScroll(consumed, available, source)
            }
        }
    }

    LazyColumn(
        modifier = modifier.nestedScroll(nestedScrollConnection),
        verticalArrangement = Arrangement.spacedBy(Spacing.Space2),
        state = listState,
        // contentPadding = PaddingValues(Spacing.Space12),
    ) {
        item {
            Row(
                modifier = modifier
                    .background(color = DynamicColor.appBackground)
                    .padding(horizontal = Spacing.Space12, vertical = Spacing.Space8),
                horizontalArrangement = Arrangement.spacedBy(Spacing.Space12),
            ) {
                Text(
                    modifier = Modifier.weight(1f),
                    text = "Name",
                    style = MaterialTheme.typography.subtitle2
                )

                Text(
                    modifier = Modifier.wrapContentSize(),
                    text = "Buying/selling price",
                    style = MaterialTheme.typography.subtitle2
                )
            }
        }

        item {
            Divider(color = DynamicColor.divider, thickness = 1.dp)
        }

        itemsIndexed(items) { index, item ->
            MainCurrencyListItem(
                item = item,
                changeTextWidth = changeTextWidth,
                modifier = Modifier.fillMaxWidth()
            ) {
                // todo: Open details screen
                // navController.navigate("${Route.TRANSACTION_DETAILS}/${transaction.id}")
            }
            // if (index < items.lastIndex) Divider(color = DynamicColor.divider, thickness = 1.dp)
        }
    }
}
