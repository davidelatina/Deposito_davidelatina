package com.example.todolist.service;

import com.example.todolist.model.Utente;
import com.example.todolist.repository.UtenteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UtenteService {

  private final UtenteRepository utenteRepository;

  public List<Utente> findAll() {
    return utenteRepository.findAll();
  }

  public Utente findById(Long id) {
    return utenteRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Utente non trovato"));
  }

  public Utente save(Utente utente) {
    return utenteRepository.save(utente);
  }

  public void delete(Long id) {
    utenteRepository.deleteById(id);
  }
}
