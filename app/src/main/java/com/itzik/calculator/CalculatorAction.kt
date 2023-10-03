package com.itzik.calculator

sealed class CalculatorAction {
    data class Number(val number: Int) : CalculatorAction()
    object Clear : CalculatorAction()
    object Delete : CalculatorAction()
    data class Operation(val operation: CalculatorOperation) : CalculatorAction()
    object Calculate : CalculatorAction()
    object Decimal : CalculatorAction()
}



sealed class CalculatorOperation(val symbol: String) {
    object Add : CalculatorOperation("+")
    object Subtract : CalculatorOperation("-")
    object Multiply : CalculatorOperation("x")
    object Divide : CalculatorOperation("/")
    object Power : CalculatorOperation("Pow")
    object Percentage : CalculatorOperation("%")
}

data class CalculatorState(
    val number1: String = "",
    val number2: String = "",
    val operation: CalculatorOperation? = null,
)