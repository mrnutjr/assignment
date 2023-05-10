package com.assignment.assignmenttest.webclient;

import com.assignment.assignmenttest.model.RandomUserResponse;
import com.assignment.assignmenttest.webclient.model.RandomUserClientResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Objects;

@Service
public class RandomUserClient {

    @Value("${url-random-user}")
    private String urlRandomUser;

    private final ObjectMapper objectMapper;

    public RandomUserClient(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    public RandomUserClientResponse callRandomUser(String seed) throws JsonProcessingException {
        RestTemplate restTemplate = new RestTemplate();
        String url = urlRandomUser+"?seed="+seed;
        System.out.println("call service with url path : "+ url);
        var response
                = restTemplate.getForEntity(urlRandomUser+"?seed=" + seed, String.class);
        if(response.getStatusCode()!= HttpStatus.OK){
            System.out.println("call service error : "+ response.getBody());
        }
        System.out.println("response random user api : "+ response.getBody());
        return objectMapper.readValue(response.getBody() ,RandomUserClientResponse.class);
    }
}
