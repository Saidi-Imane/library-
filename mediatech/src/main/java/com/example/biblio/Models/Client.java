package com.example.biblio.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.io.Serializable;
import java.util.List;

@EntityScan
@Entity
@Table(name = "client")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Client implements Serializable {
    @Id
    @GeneratedValue
    private int id;
    @Column(nullable = false)
    private String  firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(name = "telephone")
    private String telephone;
    @OneToMany(mappedBy ="client" ,cascade=CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Facture> factures;

}
