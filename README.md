# Kotlin-RestAPI

## Docker
### Instalação
Para ambiente windows sem suporte a Hyper-V instalar docker toolbox, que pode ser obtida clicando [aqui](https://www.docker.com/products/docker-toolbox)
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

Para não precisar instalar o rabbitMQ na própria máquina uma boa solução é usando um container do docker.

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

## MongoDB

## Postgre
