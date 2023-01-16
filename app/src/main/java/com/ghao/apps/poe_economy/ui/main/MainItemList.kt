package com.ghao.apps.poe_economy.ui.main

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection
import androidx.compose.ui.input.nestedscroll.NestedScrollSource
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.dp
import com.ghao.apps.poe_economy.theme.DynamicColor
import com.ghao.apps.poe_economy.theme.Spacing
import com.ghao.apps.poe_economy.util.toDp
import com.ghao.lib.core.data.Item
import kotlin.math.roundToInt

@Composable
fun BoxScope.MainItemList(
    modifier: Modifier,
    listState: LazyListState,
    items: List<Item>
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
            MainItemListHeader(
                modifier = Modifier.fillMaxWidth().wrapContentHeight(),
                changeTextWidth = changeTextWidth
            )
        }

        item {
            Divider(color = DynamicColor.divider, thickness = 1.dp)
        }

        itemsIndexed(items) { index, item ->
            MainItemListItem(
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

    val hideStickyHeader by remember {
        derivedStateOf {
            listState.firstVisibleItemIndex == 0 && listState.firstVisibleItemScrollOffset == 0
        }
    }

    StickyItemListHeader(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .align(alignment = Alignment.TopCenter)
            .offset(y = scrollDelta.roundToInt().toDp())
            .alpha(if (hideStickyHeader) 0f else 1f)
            .onGloballyPositioned {
                headerHeight = it.size.height.toFloat()
            },
        changeTextWidth = changeTextWidth
    ) {
        changeTextWidth = it.size.width
    }
}