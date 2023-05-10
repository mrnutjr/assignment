package com.assignment.test.controller

import com.assignment.test.service.RandomUserService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/v1")
@RestController
class RandomUserController(val randomUserService: RandomUserService) {

    @GetMapping("/user/{seed}")
    fun getUser(@PathVariable seed: String) = randomUserService.getUser(seed)
}