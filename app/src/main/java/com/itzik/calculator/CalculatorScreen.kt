package com.itzik.calculator

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import com.itzik.calculatoruitest.R
import com.itzik.theme.LightPink
import com.itzik.theme.LightPurple

@SuppressLint("SuspiciousIndentation")
@Composable
fun CalculatorScreen(
    state: CalculatorState,
    modifier: Modifier,
    onAction: (CalculatorAction) -> Unit,
) {
    ConstraintLayout(modifier = modifier) {
        val (textBox, buttonsColumn) = createRefs()

        val data = state.number1 + (state.operation?.symbol ?: "") + state.number2


        Text(
            text = data,
            textAlign = TextAlign.End,
            modifier = modifier
                .fillMaxWidth()
                .padding(top = 32.dp)
                .constrainAs(textBox) {
                    top.linkTo(parent.top)
                }
                .fillMaxWidth().clip(RoundedCornerShape(bottomEnd = 12.dp, bottomStart = 12.dp))
                .height(200.dp)
                .background(LightPurple),
            fontWeight = FontWeight.Light,
            fontSize = 80.sp,
            color = Color.Black,
            maxLines = 2
        )


        LazyVerticalGrid(
            modifier = modifier
                .constrainAs(buttonsColumn) {
                    top.linkTo(textBox.bottom)
                    bottom.linkTo(parent.bottom)
                }
                .fillMaxWidth(),
            columns = GridCells.Fixed(4),
        ) {
            items(buttons.size) { index ->
                val button = buttons[index]
                CalculatorButton(
                    symbol = button,
                    painter = painterResource(id = R.drawable.baseline_backspace_24),
                    modifier = Modifier
                        .padding(8.dp)
                        .background(LightPink)
                ) {
                    onAction(
                        when (button) {
                            "%" -> CalculatorAction.Operation(CalculatorOperation.Percentage)
                            "AC" -> CalculatorAction.Clear
                            "^" -> CalculatorAction.Operation(CalculatorOperation.Power)
                            "/" -> CalculatorAction.Operation(CalculatorOperation.Divide)
                            "7" -> CalculatorAction.Number(7)
                            "8" -> CalculatorAction.Number(8)
                            "9" -> CalculatorAction.Number(9)
                            "X" -> CalculatorAction.Operation(CalculatorOperation.Multiply)
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
