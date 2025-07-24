package com.example.library.controller;


import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import com.example.library.model.Libreria;

import com.example.library.service.LibreriaService;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api/libreria")
public class LibreriaController {

  private final LibreriaService service;

  public LibreriaController(LibreriaService service) {
    this.service = service;
  }

  @GetMapping
  public List<Libreria> getAll() {
    return service.getAll();
  }

  @GetMapping("/{id}")
  public ResponseEntity<Libreria> getById(@PathVariable Long id) {
    return service.getById(id).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
  }

  @PostMapping
  public ResponseEntity<Libreria> create(@RequestBody Libreria nuovo) {
    Libreria creato = service.create(nuovo);
    return ResponseEntity.status(HttpStatus.CREATED).body(creato);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Libreria> update(@PathVariable Long id, @RequestBody Libreria modificato) {
    return service.update(id, modificato).map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> delete(@PathVariable Long id) {
    boolean rimosso = service.delete(id);
    return rimosso ? ResponseEntity.noContent().build() : ResponseEntity.notFound().build();
  }

  @GetMapping("/titolo")
  public List<Libreria> getByTitolo(@PathVariable String titolo) {
    return service.getByTitolo(titolo);
  }

  @GetMapping("/autore")
  public List<Libreria> getByAutore(@PathVariable String autore) {
    return service.getByAutore(autore);
  }

}
