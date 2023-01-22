package com.Masiv.repositories;


import com.Masiv.DTO.ComunicationDTO;
import com.Masiv.models.Comunication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface ComunicationRepository extends JpaRepository <Comunication, Long> {
    Comunication findById (long id);


    List<Comunication> findAll();

}

