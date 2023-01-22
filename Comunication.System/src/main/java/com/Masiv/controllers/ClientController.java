package com.Masiv.controllers;
import com.Masiv.models.Client;
import com.Masiv.DTO.ClientDTO;
import com.Masiv.repositories.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;


@RestController
public class ClientController {
    @Autowired
    private ClientService clientService;

    @Autowired
    private PasswordEncoder passwordEncoder;




    @GetMapping("/api/clients/{id}")
    public ClientDTO getClient(@PathVariable Long id) {
        return new ClientDTO(clientService.findClientId(id));
    }

    @PostMapping(path = "/api/clients")
    public ResponseEntity<Object> register(

            @RequestParam String name, @RequestParam String lastName,

            @RequestParam String email, @RequestParam String password) {

        if (name.isEmpty()) {
            return new ResponseEntity<>("Name is empty", HttpStatus.FORBIDDEN);
        }
        if ( lastName.isEmpty()) {
            return new ResponseEntity<>("Last Name is empty", HttpStatus.FORBIDDEN);
        }
        if ( email.isEmpty() ) {
            return new ResponseEntity<>("Email is empty", HttpStatus.FORBIDDEN);
        }
        if ( password.isEmpty()) {
            return new ResponseEntity<>("Password is empty", HttpStatus.FORBIDDEN);
        }

        if(!email.contains("@") || !email.contains(".com") ){
            return new ResponseEntity<>("Invalid email", HttpStatus.FORBIDDEN);
        }
        if (clientService.findClientEmail(email) !=  null) {
            return new ResponseEntity<>("Email already in use", HttpStatus.FORBIDDEN);
        }
        if(password.length() < 8 ){
            return new ResponseEntity<>("The password must contain at least 8 characters", HttpStatus.FORBIDDEN);
        }

        Client client =  new Client(name, lastName, email, passwordEncoder.encode(password));
//        Client client =  new Client(name, lastName, email, Base64.getEncoder().encodeToString(password.getBytes()));

        clientService.saveClient(client);
            return new ResponseEntity<>( client,HttpStatus.CREATED);
    }

    @GetMapping("/api/clients/current")
    public ClientDTO getAll(Authentication authentication){
        return  new ClientDTO(clientService.findClientEmail(authentication.getName()));
    }

}
