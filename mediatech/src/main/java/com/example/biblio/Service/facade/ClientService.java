package com.example.biblio.Service.facade;

import com.example.biblio.DTO.ClientRequestDto;
import com.example.biblio.DTO.ClientResponseDto;

import java.util.List;

public interface ClientService {
ClientResponseDto save(ClientRequestDto clientRequestDto);
ClientResponseDto findById(int id);
ClientResponseDto findByFirstName(String firstName);
void  delete(int id);
ClientResponseDto update(ClientRequestDto clientResponseDto, int id);
List<ClientResponseDto> findAll();

}
