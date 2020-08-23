package com.jainn.treasureHunt.controller;

import com.jainn.treasureHunt.service.TokenService;
import com.jainn.treasureHunt.util.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/")
public class AdminController {

    @Autowired
    private TokenService tokenService;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value = "register/{name}" , method = RequestMethod.POST)
    public String register(@PathVariable String name, @RequestHeader(value="token") String token){
        if(token != null && !token.isEmpty() && token.equalsIgnoreCase("92668751")){
            tokenService.generateAndSaveToken(name);
            return "User is registered successfully!!";
        } else {
            return "You are not authorised for this operation!!";
        }
    }

    @RequestMapping("fetch/{name}")
    public String fetchToken(@PathVariable String name, @RequestHeader(value="token") String token){
        if(token != null && !token.isEmpty() && token.equalsIgnoreCase("92668751")){
            return tokenService.fetchToken(name).get(0).getToken();
        } else {
            return "You are not authorised for this operation!!";
        }
    }

    @RequestMapping("fetchJWT/{name}")
    public String fetchToken(@PathVariable String name){
       return jwtUtil.generateToken(name);
    }


}
