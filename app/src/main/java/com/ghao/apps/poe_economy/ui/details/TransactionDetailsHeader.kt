package com.ghao.apps.poe_economy.ui.details

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ghao.apps.poe_economy.theme.DynamicColor
import com.ghao.apps.poe_economy.theme.Spacer
import com.ghao.apps.poe_economy.theme.Spacing
import com.ghao.apps.poe_economy.util.getDecimalString
import com.ghao.lib.core.data.json.JsonTransaction
import com.skydoves.landscapist.glide.GlideImage

@Composable
fun TransactionDetailsHeader(modifier: Modifier, transaction: JsonTransaction) {
    Row(
        modifier = modifier
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(
                        DynamicColor.appBackground,
                        MaterialTheme.colors.surface,
                    )
                )
            )
            .padding(
                top = Spacing.Space48,
                bottom = Spacing.Space16,
                start = Spacing.Space20,
                end = Spacing.Space20
            ),
        verticalAlignment = Alignment.Bottom
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .wrapContentHeight()
                .padding(end = Spacing.Space12),
            verticalArrangement = Arrangement.spacedBy(Spacing.Space2)
        ) {
            GlideImage(
                modifier = Modifier
                    .size(72.dp),
                imageModel = {
                    transaction.logoUrl
                },
            )
            Spacer(space = Spacing.Space4)
            Text(
                modifier = Modifier.wrapContentSize(),
                text = transaction.merchantName,
                style = MaterialTheme.typography.h6.copy(fontWeight = FontWeight.Bold, fontSize = 22.sp),
                maxLines = 3
            )
            Text(
                modifier = Modifier.wrapContentSize(),
                text = transaction.date,
                style = MaterialTheme.typography.body1.copy(color = DynamicColor.secondaryText)
            )
        }

        Row(
            modifier = Modifier.wrapContentSize(),
            verticalAlignment = Alignment.Bottom
        ) {
            Text(
                modifier = Modifier
                    .wrapContentSize()
                    .alignByBaseline(),
                text = "$",
                style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Bold)
            )
            val int = transaction.amount.toInt()
            Text(
                modifier = Modifier
                    .wrapContentSize()
                    .alignByBaseline(),
                text = "$int",
                style = MaterialTheme.typography.h4.copy(fontWeight = FontWeight.Bold)
            )
            val decimal = transaction.amount.getDecimalString()
            Text(
                modifier = Modifier
                    .wrapContentSize()
                    .alignByBaseline(),
                text = ".$decimal",
                style = MaterialTheme.typography.subtitle1.copy(fontWeight = FontWeight.Bold)
            )
        }
    }
}