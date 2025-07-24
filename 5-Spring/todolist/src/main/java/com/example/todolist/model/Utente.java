package com.example.todolist.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "utenti")
public class Utente {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String nome;

  @OneToMany(mappedBy = "utente", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnore
  private List<Todo> todoList;
}
