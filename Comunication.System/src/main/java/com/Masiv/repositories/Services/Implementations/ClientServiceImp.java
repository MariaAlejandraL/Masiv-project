package com.Masiv.repositories.Services.Implementations;

import com.Masiv.models.Client;
import com.Masiv.repositories.ClientRepository;
import com.Masiv.repositories.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServiceImp implements ClientService {
     @Autowired
     ClientRepository clientRepository;

    @Override
    public List<Client> findAllClient() {
        return clientRepository.findAll();
    }

    @Override
    public Client findClientId(long id) {
        return clientRepository.findById(id).orElse(null);
    }

    @Override
    public Client findClientEmail (String email){
        return  clientRepository.findByEmail(email);
    }

    @Override
    public void saveClient(Client client) {
        clientRepository.save(client);
    }

}
