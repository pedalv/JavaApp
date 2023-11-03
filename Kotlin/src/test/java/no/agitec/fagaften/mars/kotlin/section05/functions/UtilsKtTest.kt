package no.agitec.fagaften.mars.kotlin.section05.functions

import junit.framework.Assert.assertTrue
import org.junit.Test
import kotlin.test.assertEquals

class UtilsKtTest {

    @Test
    fun upperFirstAndLasttest() {
        val expected = "AbC"
        val actual = upperFirstAndLast("abc")
        assertEquals(expected, actual)
        assertTrue(true)
    }

    @Test
    fun utilsupperFirstAndLasttest() {
        val expected = "AbcdE"
        val actual = Utils().upperFirstAndLast("abcde")
        assertEquals(expected, actual)
        assertTrue(true)
    }

}