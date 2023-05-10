package com.assignment.test.webclients.model

import com.fasterxml.jackson.annotation.JsonIgnoreProperties

@JsonIgnoreProperties(ignoreUnknown = true)
data class RandomUserClientResponse (
        val results: List<ResultModel>
)

data class NameModel (
     val first: String? ,
     val last: String?
)

data class ResultModel (
     val name: NameModel?,
     val gender: String?,
     val email: String?
)
