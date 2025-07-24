package com.example.todolist.controller;

import com.example.todolist.model.Utente;
import com.example.todolist.service.UtenteService;
import com.example.todolist.service.TodoService;
import com.example.todolist.model.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/utenti")
@RequiredArgsConstructor
public class UtenteController {

  private final UtenteService utenteService;
  private final TodoService todoService;

  @GetMapping
  public List<Utente> getAllUtenti() {
    return utenteService.findAll();
  }

  @GetMapping("/{id}")
  public Utente getUtenteById(@PathVariable Long id) {
    return utenteService.findById(id);
  }

  @PostMapping
  public Utente createUtente(@RequestBody Utente utente) {
    return utenteService.save(utente);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteUtente(@PathVariable Long id) {
    utenteService.delete(id);
    return ResponseEntity.ok("Utente eliminato");
  }

  // ENDPOINT SPECIFICO: tutti i ToDo di un utente
  @GetMapping("/{id}/todo")
  public List<Todo> getTodoByUtente(@PathVariable Long id) {
    return todoService.findByUtenteId(id);
  }
}
