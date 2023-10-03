package com.itzik.calculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.calculatoruitest.R
import com.itzik.theme.LightGray

@Composable
fun CalcScreen(
    state: CalculatorState,
    modifier: Modifier = Modifier,
    buttonSpacing: Dp = 8.dp,
    onAction: (CalculatorAction) -> Unit,
) {
    Box(modifier = modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = state.number1 + (state.operation?.symbol ?: "") + state.number2,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 32.dp),
                fontWeight = FontWeight.Light,
                fontSize = 80.sp,
                color = Color.Black,
                maxLines = 2
            )

            LazyVerticalGrid(
                modifier = Modifier.fillMaxWidth(),
                columns = GridCells.Fixed(4),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                items(buttons.size) { index ->
                    val button = buttons[index]

                    CalculatorButton(
                        symbol = button,
                       painter = painterResource(id = R.drawable.baseline_backspace_24),
                        modifier = Modifier.background(LightGray)) {

                        onAction(
                            when (button) {
                                "%" -> CalculatorAction.Operation(CalculatorOperation.Percentage)
                                "AC" -> CalculatorAction.Clear
                                "Pow" -> CalculatorAction.Operation(CalculatorOperation.Power)
                                "/" -> CalculatorAction.Operation(CalculatorOperation.Divide)
                                "7" -> CalculatorAction.Number(7)
                                "8" -> CalculatorAction.Number(8)
                                "9" -> CalculatorAction.Number(9)
                                "*" -> CalculatorAction.Operation(CalculatorOperation.Multiply)
                                "4" -> CalculatorAction.Number(4)
                                "5" -> CalculatorAction.Number(5)
                                "6" -> CalculatorAction.Number(6)
                                "-" -> CalculatorAction.Operation(CalculatorOperation.Subtract)
                                "1" -> CalculatorAction.Number(1)
                                "2" -> CalculatorAction.Number(2)
                                "3" -> CalculatorAction.Number(3)
                                "+" -> CalculatorAction.Operation(CalculatorOperation.Add)
                                "Del" -> CalculatorAction.Delete
                                "0" -> CalculatorAction.Number(0)
                                "." -> CalculatorAction.Decimal
                                "=" -> CalculatorAction.Calculate
                                else -> null
                            } as CalculatorAction
                        )
                    }
                }
            }
        }
    }
}