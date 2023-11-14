package com.example.biblio.DTO;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {
//    @NotNull(message = "le prenom est obligeatoire")
//    @Size(min =3,max = 15)
    @NotBlank(message = "le prenom est obligeatoire")
    @Size(min =3,max = 15)
    private String  firstName;
    @NotBlank(message = "le nom est obligeatoire")
    @Size(min =3,max = 15)
    private String lastName;
    @NotNull
    private String telephone;
}
