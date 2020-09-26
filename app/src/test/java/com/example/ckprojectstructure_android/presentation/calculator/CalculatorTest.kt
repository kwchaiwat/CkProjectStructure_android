package com.example.ckprojectstructure_android.presentation.calculator

import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.rules.ExpectedException


class CalculatorTest {

    @Test
    fun `1 + 1 = 2`() {
        val calculator = Calculator()
        assertEquals(2, calculator.add(1, 1))
    }

    @Test
    fun `Division by not zero should return double`() {
        val calculator = Calculator()
        assertEquals(12.0, calculator.div(60, 5))
    }

    @Test
    fun `Division by zero should return error`() {
        val calculator = Calculator()
        assertEquals("Division by Zero", calculator.div(1, 0))
    }


}