package com.example.demo.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
  public int sum(int a, int b) {
    return a + b;
  }
}
