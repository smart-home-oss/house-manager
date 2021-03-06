# house manager

[![Build Status](https://travis-ci.com/smart-home-oss/house-manager.svg?branch=master)](https://travis-ci.com/smart-home-oss/house-manager)
[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=smart-home-oss_house-manager&metric=alert_status)](https://sonarcloud.io/dashboard?id=smart-home-oss_house-manager)

## System requirements

1. Java Development Kit 8+
1. Maven, 
    - _optionally you can use `mvnw`_
1. Docker
1. `docker-compose`
1. Postman

## Docs

The project docs are located under: `/docs`. 
They are split if dedicated files per topic.

## Infrastructure

The files that are launching the required dependencies 
are located in a dedicated repository: [smart-home-oss/infra](https://github.com/smart-home-oss/infra)

```text
Description:

Method springSecurityFilterChain in org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration required a bean of type 'org.springframework.security.oauth2.jwt.JwtDecoder' that could not be found.


Action:

Consider defining a bean of type 'org.springframework.security.oauth2.jwt.JwtDecoder' in your configuration.
```

```properties
# You need to declare and resource server which will create the JWTDecoder
spring.security.oauth2.resourceserver.jwt.issuer-uri=${OAUTH_ISSUER_URI:http://keycloak.localhost/auth/realms/smart-home-oss}
spring.security.oauth2.resourceserver.jwt.jwk-set-uri=${OAUTH_JWK_URI:http://keycloak.localhost/auth/realms/smart-home-oss/protocol/openid-connect/certs}
```