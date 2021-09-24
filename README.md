# Simple Example with MicroServices
###  - Para estudos apenas, não aconselho subir para produção devido a algumas questões de segurança
### -  Use only for studies, don't go up to production

### ---- Informações importantes ---- 

- Precisa inserir criptografia para senhas
- Talvez precise melhorar a forma de login/cadastro entre o Authentication-Service e Cliente-Service
- Refatorar alguns controllers e services.

## Features

- Possui ServerConfig baseado no GitHub, se quiser local precisa modificar.
- Possui SpringCloud Gateway com load balance funcionando bem. Testado com 3 instâncias.
- Possui um servidor de autenticação onde é feito o cadastro e login e outras funcionalidades
- Possui Spring Security com JWT, porém, como dito acima, precisa inserir criptografia de senhas
- Ao realizar cadastro, as informações de acesso são replicadas no banco do Authentication-Service, e as outras informações são inseridas no banco do Cliente-Service.
- Possui Swagger, que deve ser acessado diretamente por cada serviço. Nesta versão não passa pelo Gateway


### ---- Important ---- 

- Need to add encryption for passwords
- Maybe you need to improve the login/registration way between Authentication-Service and Cliente-Service
- Refactor some controllers and services.

## Features
- Has ServerConfig based on GitHub, if you want the location you need to modify it.
- It has SpringCloud Gateway with load balance working well. Tested with 3 instances.
- It has an authentication server where registration and login and other features
- It has Spring Security with JWT, however, as stated above, it needs to insert password encryption
- When registering, the access information is replicated in the Authentication-Service's bank, and the other information is entered in the Client-Service's bank.
- It has Swagger, which must be accessed directly by each service. In this version does not go through the Gateway


## Links
- http://localhost:8765/authentication-service/**
- http://localhost:8765/cliente-service/**
- http://localhost:8888/ -> ConfigServer
- http://localhost:8761/eureka
- http://localhost:8889/swagger-ui.html
- http://localhost:8000/swagger-ui.html


## Techs
- [Spring Boot]
- [IntelliJ]
- [Spring Cloud]
- [Spring Gateway]
- [Spring Security]
- [Java 11]
- [Feign Client]
