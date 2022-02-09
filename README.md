##Evaluation Project

Este projeto foi desenvolvido como proposta de desafio, para exemplificação do uso de verbos http, criação de API com autorização e validação de usuários.

**Algumas das tecnologias utilizadas **

- Spring Boot
- Spring Security
- Java
- Banco de dados em mémoria
- Gradlew

##Indicações de download
> "IntelliJ communit"- IDE utilizada para desenvolvimento da aplicação. [Link](https://www.jetbrains.com/pt-br/idea/download/#section=windows)
> "Gradle"- Gerenciador de build e dependencias utilizada na construição da aplicação. [Link](https://gradle.org/install/)

##Instruções de utilização
Para visualisar o código, é interessante que seja feito em uma IDE para visualizar de forma mais clara o código, mas nada impede que seja visualizado em qualquer editor de texto.
Se o projeto foi baixado e o computador tiver a IDE por exemplo, assim que o projeto for importado a IDE irá realizar o download de todas as dependencias necessarias da aplicação.

Para execução pelo terminal na raiz da aplicação pode-se digitar o comando:

`gradlew bootRun`

Assim que o processo for concluido aparecerá uma mensagem de build Success e então o próximo passo é subir a aplicação executando o seguinte comando:

`gradlew bootRun`

Assim que a aplicação estiver em execução, a ultima linha de log informativo da aplicação será algo como:

`Tomcat started on port(s): 8080 (http) with context path '/evaluation'`

`Started EvaluationApplication in 6.954 seconds (JVM running for 7.855)`

E apartir deste momento estaremos prontos para testar a aplicação.

Para a contrução da aplicação foi utilizado o banco de dados H2, onde ele fica em em execução na memória, ou seja quando a aplicação for desligada ele será desligado junto, e o detalhe mais importante as informações também ficam disponiveis em memória, alguns inserts foram criados para que ja se tenha algum dado para teste, todas as informações persistidas utilizado as APIS serão descartadas na proxima reinicialização da aplicação, caso queira que alguma informação perdure será necessário acrescentala no script de inicialização da base de dados, este arquivo está localizada em:

`/src/main/resources/data.sql` ele contem todas as informações que já são inseridas na inicialização da aplicação, então basta adicionar o insert junto com os que a aplicação já utiliza.

Para acessar as informações da base de dados pode acessar através da interface do H2, com a aplicação em execução, digite em um navegador o endereço `http://localhost:8080/evaluation/h2-console`

Na tela apresentada utilize as configurações a seguir:

Driver Class: `org.h2.Driver`

JDBC URL:    `jdbc:h2:mem:testdb`

User Name: `sa`

User Name: `password`


Realizado o conect com a base de dados pode-se realizar consultas no banco para confirmar a interação com a base x API

Nesta aplicação foi adcionado o swagger que é muito utilizado para documentação e ferramenta desigin para API, através da página disponibilizada para interação com o usuário é possivel testar todas as APIS da aplicação diretamente do navegador

`http://localhost:8080/evaluation/swagger-ui/index.html`

Para auxiliar nos testes tamém foi criado uma workspace na aplicação postman, e para utilizar-la basta importar o arquivo:

`evaluation.postman_collection.json`

Que está localizado na raiz do projeto.

Para qualquer dúvida estou a disposição para auxiliar.
