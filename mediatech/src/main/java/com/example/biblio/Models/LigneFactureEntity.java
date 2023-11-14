package com.example.biblio.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
@Entity
@Data
@ToString
@Table(name = "Ligne_facture")
public class LigneFactureEntity implements Serializable {
    @EmbeddedId
    private LigneFactureKey id;
    @ManyToOne
    @MapsId("produitId")
    @JoinColumn(name = "produit_id")
    private Produit produit;
    @ManyToOne
    @MapsId("factureId")
    @JoinColumn(name = "facture_Id")
    private Facture facture;

    private double quantite;
}
