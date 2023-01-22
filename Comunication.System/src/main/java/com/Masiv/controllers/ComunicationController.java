package com.Masiv.controllers;
import com.Masiv.DTO.ComunicationDTO;
import com.Masiv.models.Client;
import com.Masiv.models.Comunication;
import com.Masiv.repositories.ComunicationRepository;
import com.Masiv.repositories.Services.ClientService;
import com.Masiv.repositories.Services.ComunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ComunicationController {

    @Autowired
    ClientService clientService;

    @Autowired
    ComunicationService comunicationService;

    @Autowired
    ComunicationRepository comunicationRepository;

    @GetMapping(path = "/api/comunications")
   public List<Comunication> getComunication() {
        return comunicationService.findAllComunications();
    };

    @PostMapping(path = "/api/comunication/admin")
    public ResponseEntity<String> createComunication (@RequestParam String title,  @RequestParam String content , Authentication authentication){

        if(title.isEmpty()){
            return new ResponseEntity<>("Name is empty", HttpStatus.FORBIDDEN);
        }
        if(content.isEmpty()){
            return  new ResponseEntity<>("Content is empty", HttpStatus.FORBIDDEN);
        }

        Client admin = clientService.findClientEmail(authentication.getName());

        Comunication newComunication =  new Comunication( title , content );

        comunicationRepository.save(newComunication);

//        comunicationService.saveComunication(newComunication);
        return new ResponseEntity<>("Communication created successfully ",HttpStatus.CREATED);
    }

}
