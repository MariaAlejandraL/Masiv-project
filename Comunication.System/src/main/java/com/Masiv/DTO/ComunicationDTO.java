package com.Masiv.DTO;

import com.Masiv.models.Comunication;


public class ComunicationDTO {
    private long id;
    private String title;
    private String content;

    public ComunicationDTO() {
    }
    public ComunicationDTO(String title, String content) {
        this.title = title;
        this.content = content;
    }
    public ComunicationDTO(Comunication comunication) {
    }
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}