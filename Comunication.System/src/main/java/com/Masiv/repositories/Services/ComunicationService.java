package com.Masiv.repositories.Services;

import com.Masiv.models.Comunication;

import java.util.List;

public interface ComunicationService {
    public List<Comunication> findAllComunications ();

    public void saveComunication(Comunication comunication);
}

