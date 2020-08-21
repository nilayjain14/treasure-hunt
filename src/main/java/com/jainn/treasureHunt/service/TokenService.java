package com.jainn.treasureHunt.service;

import com.jainn.treasureHunt.model.Participant;

import java.util.List;

public interface TokenService {

    public String generateAndSaveToken(String name);

    public List<Participant> fetchToken(String name);
}
