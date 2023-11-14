package com.example.biblio.Dao;

import com.example.biblio.Models.LigneFactureEntity;
import com.example.biblio.Models.LigneFactureKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LigneFactureDao extends JpaRepository<LigneFactureEntity, LigneFactureKey> {
}
