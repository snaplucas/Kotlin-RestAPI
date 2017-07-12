# Kotlin-RestAPI
## Spring - módulos utilizados
* Spring boot
* Spring mvc
* Spring data
* Spring amqp

## Conceitos aplicados
* SOLID
* Clean Architecture
* Dependency Injection
* Factory Method
* Adapter
* Repository Pattern

## Docker
### Instalação
Em ambientes windows sem suporte a Hyper-V instalar docker toolbox, que pode ser obtido [aqui](https://www.docker.com/products/docker-toolbox)
e rodar o QuickStart

Especificando a shell a ser usada pelo docker em um terminal
``` bash
$ docker-machine start <nomeDaMachine>
```
``` bash
$ docker-machine env --shell cmd <nomeDaMachine>
```
``` bash
$ @FOR /f "tokens=*" %i IN ('docker-machine env --shell cmd teste') DO @%i
```

## RabbitMQ

Para não precisar instalar o rabbitMQ na própria máquina uma boa solução é usar um container do docker.

Fazer pull da imagem oficial do rabbitMQ
``` bash
$ docker pull rabbitmq
```

Criar um container do rabbitMQ expondo as portas padrão
``` bash
$ docker run -d --hostname my-rabbit --name some-rabbit -p 15672:15672 -p 5672:5672 rabbitmq:3-management
```

Para descobrir o IP da máquina virtual:
``` bash
$ docker-machine ip dev
```

## Swagger
A documentação da API foi feita utiilzando o framework swagger. Para visualiza-la basta acessar http://localhost:8888/swagger-ui.html com a aplicação rodando.

## KTOR
As configurções do ktor estão em application.conf e o servidor http esta subindo na porta 8080
https://github.com/Kotlin/ktor

## MongoDB

## PostgreSQL
