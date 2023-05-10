package com.assignment.assignmenttest.controller;

import com.assignment.assignmenttest.model.RandomUserResponse;
import com.assignment.assignmenttest.service.RandomUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1")
public class RandomUserController {

    private final RandomUserService randomUserService;

    public RandomUserController(RandomUserService randomUserService) {
        this.randomUserService = randomUserService;
    }

    @GetMapping("/user/{seed}")
    ResponseEntity<RandomUserResponse> getUser(@PathVariable String seed) {
        return new ResponseEntity<>(randomUserService.getUser(seed), HttpStatus.OK);
    }
}
