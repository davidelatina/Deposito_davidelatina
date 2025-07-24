package com.example.library.model;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "libro")
public class Libreria {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "title", nullable = false, length = 255)
  private String titolo;

  @Column(name = "author", nullable = false, length = 255)
  private String autore;

  @Column(name = "price", nullable = false)
  private BigDecimal prezzo;

  // Costruttore
  Libreria(String title, String author, BigDecimal price) {
    this.titolo = title;
    this.autore = author;
    this.prezzo = price;
  }
}
