package com.jainn.treasureHunt.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/")
public class ParticipantController {

    @RequestMapping(produces = "application/json", method = RequestMethod.GET, value = "input")
    @ResponseBody
    public String getQuestion(@RequestHeader(value="token") String token) {
        return null;
    }
}
