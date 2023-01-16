package com.ghao.apps.poe_economy.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.LayoutCoordinates
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ghao.apps.poe_economy.theme.DynamicColor
import com.ghao.apps.poe_economy.theme.Spacing
import com.ghao.apps.poe_economy.util.toDp

@Composable
fun ItemListHeader(
    modifier: Modifier = Modifier,
    changeTextWidth: Int,
) {
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
            text = "Value",
            style = MaterialTheme.typography.subtitle2
        )

        Text(
            modifier = Modifier.width(changeTextWidth.toDp()),
            text = "Change",
            style = MaterialTheme.typography.subtitle2.copy(
                textAlign = TextAlign.End
            )
        )
    }
}

@Composable
fun StickyItemListHeader(
    modifier: Modifier = Modifier,
    changeTextWidth: Int,
    onChangeTextPositioned: (LayoutCoordinates) -> Unit
) {
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
            text = "Value",
            style = MaterialTheme.typography.subtitle2
        )

        Box(modifier = Modifier.wrapContentSize()) {
            Text(
                modifier = Modifier
                    .wrapContentSize()
                    .onGloballyPositioned(onChangeTextPositioned),
                text = "+890.44%",
                style = MaterialTheme.typography.body1.copy(
                    fontWeight = FontWeight.Medium,
                    textAlign = TextAlign.End,
                    color = DynamicColor.appBackground
                )
            )
            Text(
                modifier = Modifier.width(changeTextWidth.toDp()),
                text = "Change",
                style = MaterialTheme.typography.subtitle2.copy(
                    textAlign = TextAlign.End
                )
            )
        }
    }
}