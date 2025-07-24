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
@Table(name = "todo")
public class Todo {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String descrizione;

  private boolean completato;

  @ManyToOne
  @JoinColumn(name = "utente_id", nullable = false)
  private Utente utente;

  @OneToMany(mappedBy = "todo", cascade = CascadeType.ALL, orphanRemoval = true)
  @JsonIgnore
  private List<Commento> commenti;
}
