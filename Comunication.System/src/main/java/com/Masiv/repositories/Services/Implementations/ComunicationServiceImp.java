package com.Masiv.repositories.Services.Implementations;

import com.Masiv.models.Comunication;
import com.Masiv.repositories.ComunicationRepository;
import com.Masiv.repositories.Services.ComunicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComunicationServiceImp implements ComunicationService {


    @Autowired
    ComunicationRepository comunicationRepository;

    @Override
    public List<Comunication> findAllComunications(){
        return comunicationRepository.findAll();
    }

    @Override
    public void saveComunication(Comunication comunication){
        comunicationRepository.save(comunication);
    }

}

