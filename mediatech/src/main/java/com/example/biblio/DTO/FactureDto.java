package com.example.biblio.DTO;

import com.example.biblio.Models.Client;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FactureDto {
    @NotNull
    private String ref;
    @NotNull
    private Date date;
    @NotNull
    private Client client;
}
