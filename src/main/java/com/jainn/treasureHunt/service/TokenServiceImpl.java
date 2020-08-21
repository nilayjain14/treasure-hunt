package com.jainn.treasureHunt.service;

import com.jainn.treasureHunt.constant.ApplicationConstant;
import com.jainn.treasureHunt.model.Participant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TokenServiceImpl implements TokenService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Value("${query.fetch.token}")
    private String fetchToken;


    @Override
    public String generateAndSaveToken(String name) {
        String token = String.valueOf(name.hashCode());
        jdbcTemplate.update("INSERT INTO participant (name,token) VALUES( '" + name + "','" + token + "')");
        return token;
    }

    @Override
    public List<Participant> fetchToken(String name) {
        return jdbcTemplate.query(fetchToken, new Object[]{name} ,
                (rs, rowNum) -> new Participant(rs.getString(ApplicationConstant.TOKEN)));
    }

}
