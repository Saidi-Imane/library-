package com.example.biblio.Service.facade;

import com.example.biblio.DTO.ProduitDto;
import com.example.biblio.Models.LigneFactureEntity;
import com.example.biblio.Models.LigneFactureKey;

import java.util.List;

public interface LigneFactureService {
    LigneFactureEntity save(LigneFactureEntity ligneFactureEntity);
    List< LigneFactureEntity> findAll();
}
