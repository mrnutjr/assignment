package com.assignment.test.service

import com.assignment.test.service.model.RandomUserResponse
import com.assignment.test.webclients.RandomUserClient
import com.assignment.test.webclients.model.ResultModel
import org.springframework.stereotype.Service

@Service
class RandomUserService (val randomUserClient: RandomUserClient){

     fun getUser(seed : String): RandomUserResponse? {
        val responseClient = randomUserClient.callRandomUser(seed)?.results?.firstOrNull();
        return responseClient?.let { mappingDataRandomUser(it) }
    }

    private fun mappingDataRandomUser(randomUserClientResponse: ResultModel)=
            randomUserClientResponse.let{ s->
                RandomUserResponse(firstname = s.name?.first.orEmpty(),
                        lastname = s.name?.last.orEmpty(),
                        gender = s.gender.orEmpty(),
                        email = s.email.orEmpty())
            }
}