package com.assignment.assignmenttest.service;

import com.assignment.assignmenttest.model.RandomUserResponse;
import com.assignment.assignmenttest.webclient.RandomUserClient;
import com.assignment.assignmenttest.webclient.model.NameModel;
import com.assignment.assignmenttest.webclient.model.RandomUserClientResponse;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.stereotype.Service;

@Service
public class RandomUserService {

    private final RandomUserClient randomUserClient;

    public RandomUserService(RandomUserClient randomUserClient) {
        this.randomUserClient = randomUserClient;
    }

    public RandomUserResponse getUser(String seed){
        RandomUserClientResponse responseClient = new RandomUserClientResponse();
        try {
            responseClient = randomUserClient.callRandomUser(seed);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return mappingDataRandomUser(responseClient);
    }

    public RandomUserResponse mappingDataRandomUser(RandomUserClientResponse randomUserClientResponse){
        RandomUserResponse randomUserResponse = new RandomUserResponse();
        var result = randomUserClientResponse.getResults().stream().findFirst();
        if(result.isPresent()){
            NameModel nameModel= result.get().getName();
            if(nameModel!=null) {
                randomUserResponse.setFirstName(nameModel.getFirst());
                randomUserResponse.setLastName(nameModel.getLast());
            }
            randomUserResponse.setGender(result.get().getGender());
            randomUserResponse.setEmail(result.get().getEmail());
        }
        return randomUserResponse;
    }
}
