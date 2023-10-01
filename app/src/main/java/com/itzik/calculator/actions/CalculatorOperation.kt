package com.itzik.calculator.actions

sealed class CalculatorOperation(val symbol: String) {
    object Add: CalculatorOperation("+")
    object Subtract: CalculatorOperation("-")
    object Multiply: CalculatorOperation("x")
    object Divide: CalculatorOperation("/")
    object Power:CalculatorOperation("Pow")
    object Percentage:CalculatorOperation("%")
}