package com.assignment.test.properties

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.stereotype.Component

@Component
@ConfigurationProperties(prefix = "api")
data class ApiConfiguration(
        var url: String = ""
)
