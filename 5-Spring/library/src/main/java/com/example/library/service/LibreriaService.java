package com.example.library.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.library.model.Libreria;
import com.example.library.repository.LibreriaRepository;

@Service
public class LibreriaService {

  private final LibreriaRepository repo;

  LibreriaService(LibreriaRepository repo) {
    this.repo = repo;
  }

  public List<Libreria> getAll() {
    List<Libreria> lista = new ArrayList<>();
    repo.findAll().forEach(lista::add);
    return lista;
  }

  public Optional<Libreria> getById(Long id) {
    return repo.findById(id);
  }

  public Libreria create(Libreria nuovo) {
    return repo.save(nuovo);
  }

  public Optional<Libreria> update(Long id, Libreria modificata) {
    return repo.findById(id).map(t -> {
      t.setTitolo(modificata.getTitolo());
      t.setAutore(modificata.getAutore());
      t.setPrezzo(modificata.getPrezzo());
      return repo.save(t);
    });
  }

  public boolean delete(Long id) {
    if (repo.existsById(id)) {
      repo.deleteById(id);
      return true;
    }
    return false;
  }


  public List<Libreria> getByAutore(String autoreKey) {
    return repo.findByAutoreContainingIgnoreCase(autoreKey);
  }

  public List<Libreria> getByTitolo(String titoloKey) {
    return repo.findByTitoloContainingIgnoreCase(titoloKey);
  }
}
