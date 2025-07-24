package com.example.todolist.service;

import com.example.todolist.model.Commento;
import com.example.todolist.repository.CommentoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentoService {

  private final CommentoRepository commentoRepository;

  public List<Commento> findAll() {
    return commentoRepository.findAll();
  }

  public List<Commento> findByTodoId(Long todoId) {
    return commentoRepository.findByTodoId(todoId);
  }

  public Commento findById(Long id) {
    return commentoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Commento non trovato"));
  }

  public Commento save(Commento commento) {
    return commentoRepository.save(commento);
  }

  public void delete(Long id) {
    commentoRepository.deleteById(id);
  }
}
