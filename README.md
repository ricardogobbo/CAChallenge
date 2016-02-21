# Desafio Conta Azul

## Requisitos do Sistema

Java SDK 8.0
Maven 3.1 ou mais atual

## Teste

Para executar os testes, execute o seguinte comando

`mvn clean compile test`

## Executando o Wildfly

Para inicializar o servidor Wildfly 10.0.0-Final, basta executar o seguinte comando:

`mvn wildfly:start`

Todas as dependências necessárias serão automaticamente configuradas pelo Maven.

Com o servidor online, execute o seguinte comando para Deploy

`mvn package wildfly:deploy`

## Utilizando a API REST

