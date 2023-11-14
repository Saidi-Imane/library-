package com.example.biblio.Service.Impl;

import com.example.biblio.DTO.FactureDto;
import com.example.biblio.DTO.ProduitDto;
import com.example.biblio.Dao.FactureDao;
import com.example.biblio.Models.Facture;
import com.example.biblio.Models.Produit;
import com.example.biblio.Service.facade.FactureService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FactureServiceImpl implements FactureService {
    @Autowired
    private FactureDao factureDao;
    private ModelMapper modelMapper;
    @Override
    public FactureDto save(FactureDto factureDto) {
        Facture facture =modelMapper.map(factureDto,Facture.class);
        Facture savedFacture =factureDao.save(facture);
        return modelMapper.map(savedFacture,FactureDto.class);
    }

    @Override
    public List<FactureDto> findAll() {
        return factureDao.findAll()
                .stream().map(el->modelMapper.map(el,FactureDto.class))
                .collect(Collectors.toList());
    }

}
