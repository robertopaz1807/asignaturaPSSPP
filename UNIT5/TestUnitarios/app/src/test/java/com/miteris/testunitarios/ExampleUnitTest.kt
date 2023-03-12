package com.miteris.testunitarios

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun `calculator sum should Return The Sum Between Two Parameters`() {
        //Given
        val calculator = Calculator()
        //When
        val result = calculator.sum(2, 1)
        //Then
        assertEquals(3,result)
    }

}