package com.ghao.apps.poe_economy.ui.details

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.ghao.apps.poe_economy.R
import com.ghao.apps.poe_economy.theme.DynamicColor
import com.ghao.apps.poe_economy.theme.Spacer
import com.ghao.apps.poe_economy.theme.Spacing
import com.ghao.lib.core.data.json.JsonTransaction

@Composable
fun TransactionDetailsList(
    modifier: Modifier = Modifier,
    transaction: JsonTransaction
) {
    Column(
        modifier = modifier.padding(horizontal = Spacing.Space20, vertical = Spacing.Space12),
        verticalArrangement = Arrangement.spacedBy(Spacing.Space12)
    ) {
        TransactionDetailsItem(
            modifier = Modifier.fillMaxWidth(),
            title = transaction.merchantName,
            description = stringResource(id = R.string.title_merchant_name),
        )
        TransactionDetailsItem(
            modifier = Modifier.fillMaxWidth(),
            title = transaction.merchantCategory,
            description = stringResource(id = R.string.title_category),
        )
        TransactionDetailsItem(
            modifier = Modifier.fillMaxWidth(),
            title = "${transaction.merchantCity}, ${transaction.merchantState}",
            description = stringResource(id = R.string.title_location),
        )
        TransactionDetailsItem(
            modifier = Modifier.fillMaxWidth(),
            title = transaction.cardDisplayName,
            description = stringResource(id = R.string.title_payment_information),
        )
        TransactionDetailsItem(
            modifier = Modifier.fillMaxWidth(),
            title = "**** **** **** ${transaction.cardLast4}",
            description = stringResource(id = R.string.title_card_number),
        )
        TransactionDetailsItem(
            modifier = Modifier.fillMaxWidth(),
            title = transaction.hasReceiptStr,
            description = stringResource(id = R.string.title_has_receipt),
        )

        Spacer(space = Spacing.Space12)
    }
}

@Composable
fun TransactionDetailsItem(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
) {
    Column(modifier = modifier) {
        Text(
            text = description,
            style = MaterialTheme.typography.body2.copy(color = DynamicColor.secondaryText)
        )
        Spacer(space = Spacing.Space2)
        Text(
            text = title,
            style = MaterialTheme.typography.subtitle2
        )
    }
}