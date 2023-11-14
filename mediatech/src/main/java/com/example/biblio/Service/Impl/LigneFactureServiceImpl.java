package com.example.biblio.Service.Impl;

import com.example.biblio.DTO.ProduitDto;
import com.example.biblio.Dao.LigneFactureDao;
import com.example.biblio.Models.LigneFactureEntity;
import com.example.biblio.Models.LigneFactureKey;
import com.example.biblio.Service.facade.LigneFactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LigneFactureServiceImpl implements LigneFactureService {
    @Autowired
    private LigneFactureDao ligneFactureDao;
    @Override
    public LigneFactureEntity save(LigneFactureEntity ligneFactureEntity) {
        return ligneFactureDao.save(ligneFactureEntity);
    }

    @Override
    public List<LigneFactureEntity> findAll() {
        return ligneFactureDao.findAll();
    }
}
