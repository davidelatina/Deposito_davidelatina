package com.example.demo.controller;


import com.example.demo.model.Product;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/prodotti")
public class ProductController {

  private List<Product> prodotti = new ArrayList<>();
  private Long idCounter = 1L;

  @GetMapping
  public List<Product> getAll() {
    return prodotti;
  }

  @PostMapping
  public Product crea(@RequestBody Product nuovo) {
    nuovo.setId(idCounter++);
    prodotti.add(nuovo);
    return nuovo;
  }

  @GetMapping("/{id}")
  public Product getById(@PathVariable Long id) {
    return prodotti.stream().filter(p -> p.getId().equals(id)).findFirst().orElse(null);
  }

  @PutMapping("/{id}")
  public Product aggiorna(@PathVariable Long id, @RequestBody Product modificato) {
    for (Product p : prodotti) {
      if (p.getId().equals(id)) {
        p.setNome(modificato.getNome());
        p.setPrezzo(modificato.getPrezzo());
        return p;
      }
    }
    return null;
  }

  @DeleteMapping("/{id}")
  public String elimina(@PathVariable Long id) {
    prodotti.removeIf(p -> p.getId().equals(id));
    return "Prodotto eliminato con successo.";
  }
}
