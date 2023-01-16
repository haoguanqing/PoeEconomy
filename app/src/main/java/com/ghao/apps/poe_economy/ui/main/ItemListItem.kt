package com.ghao.apps.poe_economy.ui.main

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.ghao.apps.poe_economy.R
import com.ghao.apps.poe_economy.theme.DynamicColor
import com.ghao.apps.poe_economy.theme.Spacer
import com.ghao.apps.poe_economy.theme.Spacing
import com.ghao.apps.poe_economy.theme.StaticColor
import com.ghao.apps.poe_economy.util.toDp
import com.ghao.lib.core.data.Item
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun ItemListItem(
    item: Item,
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
                .size(24.dp)
                .align(Alignment.CenterVertically),
            imageModel = {
                item.icon
            }
        )

        Column(
            modifier = Modifier.weight(1f),
        ) {
            val name = item.name + (item.links?.takeIf { it > 4 }?.let { ", ${it}L" } ?: "")
            Text(
                text = name,
                style = MaterialTheme.typography.subtitle2,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = item.baseType,
                style = MaterialTheme.typography.body2
                    .copy(color = DynamicColor.secondaryText),
                overflow = TextOverflow.Ellipsis
            )
        }

        val valueText = if (item.divineValue > 0.9f) "${item.divineValue}" else "${item.chaosValue}"
        val icon = if (item.divineValue > 0.9f) {
            painterResource(R.drawable.ic_divine_orb)
        } else {
            painterResource(R.drawable.ic_chaos_orb)
        }

        Row(modifier = Modifier.alignByBaseline()) {
            Text(
                modifier = Modifier.wrapContentSize(),
                text = valueText,
                style = MaterialTheme.typography.body1.copy(fontWeight = FontWeight.Medium)
            )
            Spacer(space = Spacing.Space2)
            Image(
                painter = icon,
                modifier = Modifier
                    .padding(top = 2.dp)
                    .size(18.dp)
                    .alignByBaseline(),
                contentDescription = null
            )
            Spacer(space = Spacing.Space4)

            Box(modifier = Modifier.wrapContentSize()) {
                // var changeTextWidth by remember { mutableStateOf(0) }
                Text(
                    modifier = Modifier
                        .wrapContentSize(),
                    text = "+890.44%",
                    style = MaterialTheme.typography.body1.copy(
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.End,
                        color = DynamicColor.appBackground
                    )
                )

                val change =
                    if (item.sparkline.totalChange >= 0) "+${item.sparkline.totalChange}%" else "${item.sparkline.totalChange}%"
                val textColor =
                    if (item.sparkline.totalChange >= 0) StaticColor.Green500.copy(alpha = 0.9f) else StaticColor.Red500.copy(
                        alpha = 0.9f
                    )
                Text(
                    modifier = Modifier.width(changeTextWidth.toDp()),
                    text = change,
                    style = MaterialTheme.typography.body1.copy(
                        fontWeight = FontWeight.Medium,
                        textAlign = TextAlign.End,
                        color = textColor
                    )
                )
            }
        }
    }
}
