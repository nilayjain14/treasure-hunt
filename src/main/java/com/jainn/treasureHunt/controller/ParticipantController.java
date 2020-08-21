package com.jainn.treasureHunt.controller;

import com.jainn.treasureHunt.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Action;

@RestController
@RequestMapping("/api/v1/")
public class ParticipantController {

    @Autowired
    private TokenService tokenService;

    @RequestMapping(method = RequestMethod.GET, value = "input")
    public String getQuestion(@RequestHeader(value="token") String token) {
        if(token != null && !token.isEmpty() && tokenService.isTokenValid(token)){
            return "success";
        } else {
            return "Please pass correct token!!";
        }
    }
}
