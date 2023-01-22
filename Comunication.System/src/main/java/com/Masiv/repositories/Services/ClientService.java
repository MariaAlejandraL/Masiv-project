package com.Masiv.repositories.Services;

import com.Masiv.models.Client;

import java.util.List;

public interface ClientService {
    public List<Client> findAllClient();
    public  Client findClientId(long id);

    public  Client findClientEmail( String email);

    public void saveClient (Client client);

}
