package com.example.biblio.DTO;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProduitDto {
    @NotBlank(message = "le libelle est obligeatoire")
    @Size(min =3,max = 15)
    private String libelle;
    @NotBlank(message = "la ref est obligeatoire")

    private String ref;
    @NotNull
    private BigDecimal prix;
    @NotNull
    private double quantiteStock;
}
