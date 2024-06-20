package com.task.cryptocurrencyapp.presentation.coin_detail.components

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun CoinTag(
    tag: String,
) {
    Box(
        modifier = Modifier
            .border(
                1.dp,
                color = MaterialTheme.colorScheme.primary,
                RoundedCornerShape(100)
            )
            .padding(10.dp)
    ){
        Text(
            text = tag,
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewCoinTag() {
    CoinTag(tag = "Segwit")
}