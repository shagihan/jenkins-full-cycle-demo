package com.example.jenkinsfullcycledemo.service;

import org.springframework.stereotype.Service;

@Service
public class CalService {

    public int addInt(int a, int b) {
        return a + b;
    }

    public int subtractInt(int a, int b) {
        return a - b;
    }

    public int multiplyInt(int a, int b) {
        return a * b;
    }

    public double divideInt(int a, int b) {
        return a * 1.0 / b;
    }

}
