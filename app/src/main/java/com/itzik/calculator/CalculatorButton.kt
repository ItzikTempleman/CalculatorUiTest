package com.itzik.calculator

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.sp

@Composable
fun CalculatorButton(
    symbol: String?=null,
    painter: Painter? = null,
    modifier: Modifier,
    onClick: () -> Unit
) {
    Box(
        modifier =  modifier.clip(CircleShape)
            .clickable {
                onClick()
            }
    ) {
        if (symbol != null) {
            Text(
                text = symbol,
                fontSize = 36.sp,
                color = Color.Black
            )
        } else painter?.let {
            Icon(
                painter = it,
                contentDescription = null,
                tint = Color.Black
            )
        }
    }
}

val buttons = listOf(
    "AC", "^","%", "/",
    "7", "8", "9", "X",
    "4", "5", "6", "-",
    "1", "2", "3", "+",
     "0", ".","Del", "="
)