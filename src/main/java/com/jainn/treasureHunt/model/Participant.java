package com.jainn.treasureHunt.model;

import lombok.Data;

@Data
public class Participant {

    String name;
    String token;
    int qID;

    public Participant(String token) {
        this.token = token;
    }
}
