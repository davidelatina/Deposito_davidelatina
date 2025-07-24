package com.example.todolist.repository;

import com.example.todolist.model.Commento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentoRepository extends JpaRepository<Commento, Long> {
  List<Commento> findByTodoId(Long todoId);
}
