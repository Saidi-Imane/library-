package com.example.biblio.Service.Impl;

import com.example.biblio.DTO.ClientRequestDto;
import com.example.biblio.DTO.ClientResponseDto;
import com.example.biblio.Dao.ClientDao;
import com.example.biblio.Models.Client;
import com.example.biblio.Service.facade.ClientService;
import com.example.biblio.exeption.EntityNotFoundExeption;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ClientServiceImpl implements ClientService {
    private ClientDao clientDao;
    private ModelMapper modelMapper;

    @Override
    public ClientResponseDto save(ClientRequestDto clientRequestDto) {
        Client client=modelMapper.map(clientRequestDto,Client.class);
        Client savedClient =clientDao.save(client);
        return modelMapper.map(savedClient,ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findById(int id) {
        Client client =clientDao.findById(id).orElseThrow(()->new EntityNotFoundExeption("client not found "));
        return modelMapper.map(client,ClientResponseDto.class);
    }

    @Override
    public ClientResponseDto findByFirstName(String firstName) {
        Client client =clientDao.findByFirstName(firstName);
        return modelMapper.map(client,ClientResponseDto.class);
    }

    @Override
    public void delete(int id) {
        clientDao.deleteById(id);

    }

    @Override
    public ClientResponseDto update(ClientRequestDto clientResponseDto, int id) {
        Optional<Client> client=clientDao.findById(id);
        if (client.isPresent()){
            Client clientEntity=modelMapper.map(clientResponseDto, Client.class);
            clientEntity.setId(id);
            Client updated  =clientDao.save(clientEntity);
            return modelMapper.map(updated,ClientResponseDto.class);
        }
        else {
            throw new EntityNotFoundExeption("Client not found ");
        }
    }

    @Override
    public List<ClientResponseDto> findAll() {
        return clientDao.findAll()
                .stream().map(el->modelMapper.map(el,ClientResponseDto.class))
                .collect(Collectors.toList());
    }
}
