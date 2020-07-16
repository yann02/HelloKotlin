package com.example.hellokotlin.standards

import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*

class MyStandardTest {

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun tRun() {
        assertEquals("b",MyStandard().tRun("b"))
    }
}