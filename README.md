# Random User API service 

# Getting Started
## Run the app

Java : mvn spring-boot:run
Kotlin : 

# REST API

The REST API of user service is described below.

## Get User

### Request
``
`GET /user/{seed}```

    curl --location 'localhost:8080/v1/user/1'

### Response

    {
    "firstname": "Janique",
    "lastname": "Costa",
    "gender": "male",
    "email": "janique.costa@example.com"
    }
