package com.example.library.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.library.model.Libreria;

@Repository
public interface LibreriaRepository extends JpaRepository<Libreria, Long> {

  List<Libreria> findByTitoloContainingIgnoreCase(String titleKey);

  List<Libreria> findByAutoreContainingIgnoreCase(String authorKey);
}
