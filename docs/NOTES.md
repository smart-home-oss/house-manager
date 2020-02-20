# NOTES

## Security and OAuth2

1. [Understanding OAuth2 and Building a Basic Authorization Server of Your Own](https://medium.com/google-cloud/understanding-oauth2-and-building-a-basic-authorization-server-of-your-own-a-beginners-guide-cf7451a16f66)
1. [Run a single MySQL query from the command line](https://electrictoolbox.com/run-single-mysql-query-command-line/)
1. [MySQL :: Connection URL Syntax](https://dev.mysql.com/doc/connector-j/8.0/en/connector-j-reference-jdbc-url-format.html)
1. [Keycloak Docker image](https://hub.docker.com/r/jboss/keycloak/)
1. [jwt.io](https://jwt.io/)
1. [Spring security JOSE](https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#spring-security-oauth2-jose)
1. [Spring Security 5.2 OAuth2 - NOT REACTIVE](https://docs.spring.io/spring-security/site/docs/current/reference/htmlsingle/#oauth2)

------------------------

@RestController - stereotype, annotation, AOP

@Autowired, dependency injection, constructor injection

Dependency resolution

Application Context

Spring beans, bean scopes, bean proxy

Stateful vs Stateless

Checked vs Unchecked exceptions

try {}
catch(RuntimeException e) {}
catch(Exception e) {}
final {}

--------------------------------

repository, persistent storage

final 

factory methods

spring boot data

interfaces, multiple inheritance

implentation clash

interface default methods

entities

repository pattern

lombok dependency and install plugin in intellij idea then go to settings, search for lombok plugin then activate it

java compiler pre-processors and post-processors

maven dependency plugin via UML plugin

---------

application properties, application profiles

pass parameters via `java -Dserver.port=3434 -Dsome.param="value with spaces" -jar app.jar`

datasource in java 

https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/htmlsingle/#boot-features-connect-to-production-database

https://docs.spring.io/spring-boot/docs/2.2.4.RELEASE/reference/htmlsingle/#using-boot-auto-configuration

https://docs.spring.io/spring-boot/docs/current/reference/html/appendix-application-properties.html

----------------

https://www.baeldung.com/spring-component-scanning

https://stormpath.com/blog/spring-boot-dependency-injection

https://www.baeldung.com/spring-dependency-injection

https://docs.spring.io/spring/docs/3.0.0.M4/spring-framework-reference/html/ch03s03.html

https://www.baeldung.com/spring-bean-scopes

thread safe + stateless (and statefull)

https://www.baeldung.com/java-stack-heap

blocking vs non-blocking

----------------- 

open api V3, editor.swagger.io

-----------------

ADM vs RDM
Anemic Domain Model vs Rich Domain Model

Testing: unit, integration, functional

SOLID, GRASP, YAGNI, YOLO

https://reflectoring.io/spring-boot-test/


------------------


java 11 
https://winterbe.com/posts/2018/08/29/migrate-maven-projects-to-java-11-jigsaw/

jacoco test reports -> sonar 
https://www.baeldung.com/jacoco

-------------------

spring data - function name dictates how sql is generated

https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#repositories.query-methods

properties classes vs configuration classes

https://docs.spring.io/spring-boot/docs/current/reference/html/spring-boot-features.html#boot-features-external-config

--------------------

Throwable vs Error vs Exception vs RuntimeException

ClassLoader 

Servlet Container (java web server) vs Application Server

https://landing.google.com/sre/

micrometter, prometheus, graphana


---------------------

Security

https://spring.io/guides/gs/securing-web/
https://www.baeldung.com/spring-security-basic-authentication
https://www.baeldung.com/spring-security-method-security

the java code is protected by spring security via anotations