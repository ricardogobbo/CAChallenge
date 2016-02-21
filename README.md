# Desafio Conta Azul

## Requisitos do Sistema

* Java SDK 8.0
* Maven 3.1 ou mais atual
* `JAVA_HOME` configurado com a JDK
* `JAVA_HOME\bin` e `MAVEN_HOME\bin` incluídas na variável PATH


## Executando o Projeto

Para inicializar o projeto, resolver as dependências e configurar o servidor Wildfly 10.0.0-Final, basta executar o seguinte comando:

`mvn wildfly:start`

Todas as dependências necessárias serão automaticamente configuradas pelo Maven.

Com as dependêncais resolvidas e o servidor configurado, execute o seguinte comando para iniciar o servidor e realizar o deploy

`mvn wildfly:run`

## Utilizando a API REST

Após realizar a inicialização do servidor e o deploy da aplicação, você será capaz de utilizar a API REST desenvolvida para este desafio.

Para solicitar a nova posição do robô, execute o seguinte comando via command line:

`curl -s --request POST http://localhost:8080/rest/mars/{COMMAND}`

`{COMMAND}` deve ser substituido pelo comando dado ao robô de acordo com a especificação do requisito.
