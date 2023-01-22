package com.Masiv.DTO;


import com.Masiv.models.Client;


public class ClientDTO {

    private String name;
    private String lastName;
    private String email;
    private long id;

    public ClientDTO() {
    }
    public ClientDTO(Client client ) {
        this.id = client.getId();
        this.name = client.getName();
        this.lastName = client.getLastName();
        this.email = client.getEmail();
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public long getId() {
        return id;
    }
}
