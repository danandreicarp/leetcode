package com.danandreicarp.number;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FizzBuzzTest {

    private final FizzBuzz app = new FizzBuzz();

    @Test
    void testCase1() {
        List<String> output = app.fizzBuzz(3);
        assertEquals(3, output.size());
        assertEquals("1", output.get(0));
        assertEquals("2", output.get(1));
        assertEquals("Fizz", output.get(2));
    }

    @Test
    void testCase2() {
        List<String> output = app.fizzBuzz(5);
        assertEquals(5, output.size());
        assertEquals("1", output.get(0));
        assertEquals("2", output.get(1));
        assertEquals("Fizz", output.get(2));
        assertEquals("4", output.get(3));
        assertEquals("Buzz", output.get(4));
    }

    @Test
    void testCase3() {
        List<String> output = app.fizzBuzz(15);
        assertEquals(15, output.size());
        assertEquals("1", output.get(0));
        assertEquals("2", output.get(1));
        assertEquals("Fizz", output.get(2));
        assertEquals("4", output.get(3));
        assertEquals("Buzz", output.get(4));
        assertEquals("Fizz", output.get(5));
        assertEquals("7", output.get(6));
        assertEquals("8", output.get(7));
        assertEquals("Fizz", output.get(8));
        assertEquals("Buzz", output.get(9));
        assertEquals("11", output.get(10));
        assertEquals("Fizz", output.get(11));
        assertEquals("13", output.get(12));
        assertEquals("14", output.get(13));
        assertEquals("FizzBuzz", output.get(14));
    }
}