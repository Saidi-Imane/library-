package com.example.biblio.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientResponseDto {
    private int id;
    private String  firstName;

    private String lastName;

    private String telephone;
}
