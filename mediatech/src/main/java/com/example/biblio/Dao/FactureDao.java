package com.example.biblio.Dao;

import com.example.biblio.Models.Facture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FactureDao extends JpaRepository<Facture,Integer> {
    Optional<Facture> findByRef(String ref);
}
