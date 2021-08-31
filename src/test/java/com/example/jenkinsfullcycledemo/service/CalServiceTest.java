package com.example.jenkinsfullcycledemo.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CalServiceTest {

    private static final int A = 25;
    private static final int B = 2;

    @Autowired
    private CalService calService;

    @Test
    @DisplayName("Unit test fro Addition")
    void addInt() {
        int expected = 27;
        int actual = calService.addInt(A, B);
        assertEquals(expected, actual, "Test failed for CalService.addInt");
    }

    @Test
    void subtractInt() {
        int expected = -23;
        int actual = calService.subtractInt(B, A);
        assertEquals(expected, actual, "Test failed for CalService.subtractInt");
    }

    @Test
    void multiplyInt() {
        int expected = 50;
        int actual = calService.multiplyInt(A, B);
        assertEquals(expected, actual, "Test failed for CalService.multiplyInt");
    }

    @Test
    void divideInt() {
        double expected = 0.008;
        double actual = calService.divideInt(B, A);
        assertEquals(expected, actual, "Test failed for CalService.divideInt");
    }

}