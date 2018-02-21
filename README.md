This is a demo Spring Boot application developed to demonstrate the use of the [Spring Cloud Config](https://cloud.spring.io/spring-cloud-config/) server as a secure and distributed configuration store. 

## What's in the repo?

* A Spring Cloud Config server, providing access to properties, both stored in plain text, as well as encrypted sensitive credentials
* A simple client application relying on the server for providing a configuration
* A shared library of dependencies

## Starting the demo

### Starting the Cloud Config Server 

```
KEYSTORE_LOCATION=classpath:/server.jks KEYSTORE_SECRET=testkeypass KEYSTORE_ALIAS=mytestkey KEYSTORE_PASSWORD=teststorepass ./gradlew :config-server:bootRun
```

### STARTING THE CLIENT APP

```bash
./gradlew :app:bootRun
```

### Client API Endpoints

```bash
GET http://localhost:8080/theAnswer
# will return 42, of course 😉

GET http://localhost:8080/theSecretAnswer
# will also return 42, but decrypt it out of AQAjSkkiCrikkvLGEKzld6GTIm6Q87iLKVGRGFZOD+bUTPUGgNmu65QTADEnBRBu89UXh9HER/96irs7LYX6FAWnZoirkSPWqOYkx4XC3lA/iVoa3/P7N4tIEh1SwtraKWP6GUs1GWuZBFIGNmaegKGFBsnej09rLSyRG2ARxWoJ2fJN9xSInwG0DceR9CBxYQjnY1RDP8o/OJSg0Ad0HhYmD6sMRbvLz1O5COLVnJZa4LRK4U/K7omSA2D1wNR8KiiZgZSRgsuUSFnCZ4/3i/faDTwJmuIJaLL5k+wR2BhqykvG19RyAN/uE74yEMHcL4JJ12SRupPzn74QEQkmmTsGXGyKYcMRsMvE9NRsc95s3HguSl2dXmb3GqEb+yHT2h0= 
first 🚀
```

### Config Server API Endpoints

#### Fetching an entire configuration manually
```bash
GET /{application}/{profile}[/{label}]
# e.g. /sccdemo/dev/master | /sccdemo/dev/sample-feature-branch-1234 | /sccdemo/prod | /sccdemo/dev,prod

GET /{application}-{profile}.yml
GET /{label}/{application}-{profile}.yml
GET /{application}-{profile}.properties
GET /{label}/{application}-{profile}.properties
```

### FAQ

**How does the encryption/decryption work?**
This repository contains a shared RSA key I created for testing and demo purposes (**NOTE:** Please, for your own good, never, ever store keys in a repository, unless they have been previously encrypted with another key!!!)

The RSA key is stored under `/config-server/src/main/resources` in order to facilitate the demo purpose. In a production environment, the key will and should be stored outside the source code base

The key comes with the following credentials (which need to be passed to the server at boot time, preferably, as environment variables):

* keystore secret - `testkeypass`
* keystore password - `teststorepass`
* key alias - `mytestkey`

## Resources

* https://cloud.spring.io/spring-cloud-config/
* https://spring.io/guides/gs/centralized-configuration/
* http://tech.asimio.net/2016/12/09/Centralized-and-Versioned-Configuration-using-Spring-Cloud-Config-Server-and-Git.html
* http://www.baeldung.com/spring-cloud-configuration
* http://jeroenbellen.com/manage-and-reload-spring-application-properties-on-the-fly/
