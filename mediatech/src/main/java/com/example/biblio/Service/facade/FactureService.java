package com.example.biblio.Service.facade;

import com.example.biblio.DTO.FactureDto;

import java.util.List;

public interface FactureService {
    FactureDto save(FactureDto factureDto);
    List<FactureDto> findAll();

}
