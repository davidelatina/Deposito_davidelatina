package com.example.demo.model;

public class DemoObject {
  private Long id;
  private int number;

  // Costruttori
  public DemoObject() {}

  public DemoObject(Long id, int number) {
    this.id = id;
    this.number = number;
  }

  // Getter e Setter
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public int getNumber() {
    return this.number;
  }

  public void setNumber(int number) {
    this.number = number;
  }
}
