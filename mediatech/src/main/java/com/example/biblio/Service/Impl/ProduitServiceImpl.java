package com.example.biblio.Service.Impl;

import com.example.biblio.DTO.ProduitDto;
import com.example.biblio.Dao.ProduitDao;
import com.example.biblio.Models.Produit;
import com.example.biblio.Service.facade.ProduitService;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProduitServiceImpl implements ProduitService {
    @Autowired
    private ProduitDao produitDao;
    private ModelMapper modelMapper;
    @Override
    public ProduitDto save(ProduitDto produitDto) {
//        if(findByref(produitDto.getRef())!=null) return null;
        Produit produit=modelMapper.map(produitDto,Produit.class);
        Produit savedProduit =produitDao.save(produit);
        return modelMapper.map(savedProduit,ProduitDto.class);

    }

    @Override
    public ProduitDto findByref(String ref) {
        Produit produit=produitDao.findByRef(ref).orElse(null);
        if (produit==null) return null;
        return modelMapper.map(produit,ProduitDto.class);
    }

    @Transactional
    @Override
    public int delete(String ref) {
        return produitDao.deleteByRef(ref);
    }

    @Override
    public ProduitDto update(ProduitDto produitDto) {
        Optional<Produit> produit=produitDao.findByRef(produitDto.getRef()) ;
        if (produit.isEmpty()) return null;
        update(produit.get(),produitDto);
        Produit saved =produitDao.save(produit.get());
        return modelMapper.map(saved,ProduitDto.class);
    }
    private void update(Produit produit,ProduitDto produitDto){
        produit.setLibelle(produitDto.getLibelle());
        produit.setPrix(produitDto.getPrix());
        produit.setQuantite_stock(produitDto.getQuantiteStock());
    }

    @Override
    public List<ProduitDto> findAll() {
        return produitDao.findAll()
                .stream().map(el->modelMapper.map(el,ProduitDto.class))
                .collect(Collectors.toList());
    }
}
