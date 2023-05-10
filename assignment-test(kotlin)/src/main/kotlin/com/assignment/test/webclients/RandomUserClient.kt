package com.assignment.test.webclients

import com.assignment.test.properties.ApiConfiguration
import com.assignment.test.webclients.model.RandomUserClientResponse
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.context.annotation.Bean
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Component
import org.springframework.web.client.RestTemplate
import java.time.Duration

@Component
class RandomUserClient(val apiConfiguration: ApiConfiguration) {

    fun callRandomUser(seed : String) : RandomUserClientResponse? {
        val url = apiConfiguration.url + "?seed="+seed
        val restTemplate = RestTemplate()
        val response = restTemplate.getForEntity(url, RandomUserClientResponse::class.java)
        if (response.statusCode !== HttpStatus.OK) {
            println("call service error : " + response.body)
        }
        println("call service response : " + response.body)
        return response.body;
    }

    @Bean
    fun restTemplate(): RestTemplate = RestTemplateBuilder()
            .setConnectTimeout(Duration.ofSeconds(10))
            .build()
}