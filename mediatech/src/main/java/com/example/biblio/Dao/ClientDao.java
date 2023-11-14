package com.example.biblio.Dao;

import com.example.biblio.Models.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientDao extends JpaRepository<Client, Integer> {
    Client findByFirstName(String firstName);

}
