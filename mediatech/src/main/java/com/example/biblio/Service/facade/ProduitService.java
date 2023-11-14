package com.example.biblio.Service.facade;


import com.example.biblio.DTO.ProduitDto;


import java.util.List;


public interface ProduitService {
    ProduitDto save(ProduitDto produitDto);
    ProduitDto findByref(String ref);
    int  delete(String ref);
    ProduitDto update( ProduitDto produitDto);
    List< ProduitDto> findAll();
}
