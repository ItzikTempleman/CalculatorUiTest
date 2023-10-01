package com

import androidx.compose.ui.test.junit4.createComposeRule
import org.junit.Rule
import org.junit.Test

class CalculatorTest {

    @get:Rule
    val rule= createComposeRule()

    @Test
    fun enterFormula_showsFormula(){
       rule.setContent { CalculatorTest() }
    }

}