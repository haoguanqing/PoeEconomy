package com.ghao.apps.poe_economy.ui.main

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import com.ghao.apps.poe_economy.theme.Spacing
import com.ghao.lib.core.data.json.CurrencyDetails
import com.ghao.lib.core.data.json.JsonCurrency
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun MainCurrencyListItem(
    item: Pair<JsonCurrency, CurrencyDetails>,
    changeTextWidth: Int,
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Row(
        modifier = modifier
            .clickable { onClick() }
            .padding(horizontal = Spacing.Space12, vertical = Spacing.Space8),
        horizontalArrangement = Arrangement.spacedBy(Spacing.Space12),
    ) {
        GlideImage(
            modifier = Modifier
                .wrapContentHeight()
                .width(20.dp)
                .align(Alignment.CenterVertically),
            imageOptions = ImageOptions(contentScale = ContentScale.FillWidth),
            imageModel = {
                item.second.icon
            }
        )

        Text(
            modifier = Modifier
                .weight(1f)
                .align(Alignment.CenterVertically),
            text = item.first.currencyTypeName,
            style = MaterialTheme.typography.body1,
            overflow = TextOverflow.Ellipsis,
            maxLines = 2,
        )

        Column {
            val buy = item.first.receive
                ?.let { String.format("%.2f", it.value) }
                ?.let { "Buy: $it C -> 1 item" }
                ?: "Buy: not enough data"
            Text(
                text = buy,
                modifier = Modifier,
                fontSize = MaterialTheme.typography.body2.fontSize,
                maxLines = 1
            )
            val sell = item.first.pay
                ?.let { String.format("%.2f", 1 / it.value) }
                ?.let { "Sell: 1 item -> $it C" }
                ?: "Sell: not enough data"
            Text(
                text = sell,
                modifier = Modifier,
                fontSize = MaterialTheme.typography.body2.fontSize,
                maxLines = 1
            )
        }
    }
}
