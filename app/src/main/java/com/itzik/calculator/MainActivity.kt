package com.itzik.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.itzik.theme.CalculatorUiTestTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorUiTestTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                CalculatorScreen(
                    state = state,
                    onAction = viewModel::onAction,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }
    }
}