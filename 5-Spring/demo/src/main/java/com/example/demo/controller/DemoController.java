package com.example.demo.controller;

import com.example.demo.service.CalculatorService;
import com.example.demo.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

  private final MessageService messageService;
  private final CalculatorService calculatorService;

  // Constructor Injection (consigliata)
  @Autowired
  public DemoController(MessageService messageService, CalculatorService calculatorService) {
    this.messageService = messageService;
    this.calculatorService = calculatorService;
  }

  @GetMapping("/sayHi")
  public String sayHi() {
    messageService.sayHi();
    return "Greeting issued";
  }

  @GetMapping("/sum")
  public int sum(@RequestParam int a, @RequestParam int b) {
    return calculatorService.sum(a, b);
  }
}
