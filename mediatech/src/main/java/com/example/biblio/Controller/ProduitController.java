package com.example.biblio.Controller;


import com.example.biblio.DTO.ProduitDto;
import com.example.biblio.Service.facade.ProduitService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("produits")
public class ProduitController {
    @Autowired
    private ProduitService produitService;
    @GetMapping("/get")
    public ResponseEntity<List<ProduitDto>> getProduits() {

        return new ResponseEntity<>(produitService.findAll(), HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<ProduitDto> save( @Valid @RequestBody() ProduitDto produitDto){
        ProduitDto produitDto1=produitService.save(produitDto);
        return new ResponseEntity<>(produitDto1,HttpStatus.CREATED);
    }
    @GetMapping("/ref/{ref}")
    public ResponseEntity<ProduitDto> findByRef(@PathVariable("ref") String ref) {
        ProduitDto produitDto=produitService.findByref(ref);
        return ResponseEntity.ok(produitDto);
    }

    @DeleteMapping("/ref/{ref}")
    public ResponseEntity<Integer> deleteByRef(@PathVariable String ref) {
        produitService.delete(ref);
        return ResponseEntity.noContent().build();
    }
    @PutMapping
    public ProduitDto update(@Valid @RequestBody ProduitDto produitDto){
        return produitService.update(produitDto);
    }
    @GetMapping("/")
    public List<ProduitDto> findAll(){
        return produitService.findAll();
    }
}
