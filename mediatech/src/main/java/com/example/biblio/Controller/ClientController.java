package com.example.biblio.Controller;

import com.example.biblio.DTO.ClientRequestDto;
import com.example.biblio.DTO.ClientResponseDto;
import com.example.biblio.Service.facade.ClientService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
public class ClientController {
    @Autowired
    private ClientService clientService;
    @GetMapping("/get")
    public ResponseEntity<List<ClientResponseDto>>  getClient() {

        return new ResponseEntity<>(clientService.findAll(), HttpStatus.OK);
    }
    @PostMapping("/post")
    public ResponseEntity<ClientResponseDto> save(@Valid @RequestBody() ClientRequestDto clientRequestDto){
        ClientResponseDto clientResponseDto=clientService.save(clientRequestDto);
       return new ResponseEntity<>(clientResponseDto,HttpStatus.CREATED);

    }
    @GetMapping("/id/{id}")
    public ResponseEntity<ClientResponseDto> findById(@PathVariable("id") int id) {
         ClientResponseDto clientResponseDto =clientService.findById(id);
         return ResponseEntity.ok(clientResponseDto);
    }
    @GetMapping("/firstName/{firstName}")
    public ResponseEntity<ClientResponseDto> findByFirstName(@PathVariable("firstName") String firstName) {
        ClientResponseDto clientResponseDto=clientService.findByFirstName(firstName);
        return ResponseEntity.ok(clientResponseDto);
    }
    @DeleteMapping("/id/{id}")
    public ResponseEntity<?> delete(@PathVariable int id) {
        clientService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PutMapping("/id/{id}")
    public ResponseEntity<ClientResponseDto>  update(@Valid @RequestBody ClientRequestDto clientRequestDto, @PathVariable int id) {
        ClientResponseDto clientResponseDto=clientService.update(clientRequestDto, id);
        return ResponseEntity.accepted().body(clientResponseDto);

    }


}
