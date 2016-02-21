# Desafio Conta Azul

## Requisitos do Sistema

* Java SDK 8.0
* Maven 3.1 ou mais atual

## Teste

Para executar os testes, execute o seguinte comando

`mvn clean compile test`

## Executando o Wildfly

Para inicializar o servidor Wildfly 10.0.0-Final, basta executar o seguinte comando:

`mvn wildfly:start`

Todas as depend�ncias necess�rias ser�o automaticamente configuradas pelo Maven.

Com o servidor online, execute o seguinte comando para Deploy

`mvn package wildfly:deploy`

## Utilizando a API REST

Ap�s realizar a inicializa��o do servidor e o deploy da aplica��o, voc� ser� capaz de utilizar a API REST desenvolvida para este desafio.

Para solicitar a nova posi��o do rob�, execute o seguinte comando via command line:

`curl -s --request POST http://localhost:8080/rest/mars/{COMMAND}`

`{COMMAND}` deve ser substituido pelo comando dado ao rob� de acordo com a especifica��o do requisito.
