##Evaluation Project

Este projeto foi desenvolvido como proposta de desafio, para exemplificação do uso de verbos http, criação de API com autorização e validação de usuários.

**Algumas das tecnologias utilizadas **

- Spring Boot
- Spring Security
- Java
- Banco de dados em memoria
- Gradlew

##Indicações de download
> "IntelliJ communit"- IDE utilizada para desenvolvimento da aplicação. [Link](https://www.jetbrains.com/pt-br/idea/download/#section=windows)

> "Gradle"- Gerenciador de build e dependências utilizada na construção da aplicação. [Link](https://gradle.org/install/)

##Instruções de utilização
Para visualizar o código, é interessante que seja feito em uma IDE para visualizar de forma mais clara o código, mas nada impede que seja visualizado em qualquer editor de texto.
Se o projeto foi baixado e o computador tiver a IDE por exemplo, assim que o projeto for importado a IDE irá realizar o download de todas as dependências necessárias da aplicação.


Para execução da aplicação pelo terminal, baixe o código do projeto e na raiz dos códigos fontes execute o comando:

`gradlew bootRun`

Assim que o processo for concluído aparecerá uma mensagem de build Success e então o próximo passo é subir a aplicação executando o seguinte comando:

`gradlew bootRun`

Assim que a aplicação estiver em execução, a ultima linha de log informativo da aplicação será algo como:

`Tomcat started on port(s): 8080 (http) with context path '/evaluation'`

`Started EvaluationApplication in 6.954 seconds (JVM running for 7.855)`

E a partir deste momento estaremos prontos para testar a aplicação.

Para a construção da aplicação foi utilizado o banco de dados H2, onde ele fica em execução na memória, ou seja quando a aplicação for desligada ele será desligado junto, e o detalhe mais importante as informações também ficam disponíveis em memória, alguns inserts foram criados para que já se tenha algum dado para teste, todas as informações persistidas utilizado as APIS serão descartadas na próxima reinicialização da aplicação, caso queira que alguma informação perdure será necessário acrescenta-la no script de inicialização da base de dados, este arquivo está localizada em:

`/src/main/resources/data.sql` ele contem todas as informações que já são inseridas na inicialização da aplicação, então basta adicionar o insert junto com os que a aplicação já utiliza.

Para acessar as informações da base de dados pode acessar através da interface do H2, com a aplicação em execução, digite em um navegador o endereço `http://localhost:8080/evaluation/h2-console`

Na tela apresentada utilize as configurações a seguir:

Driver Class: `org.h2.Driver`

JDBC URL:    `jdbc:h2:mem:testdb`

User Name: `sa`

User Name: `password`


Realizado o conect com a base de dados pode-se realizar consultas no banco para confirmar a interação com a base x API

Nesta aplicação foi adicionado o Swagger que é muito utilizado para documentação e ferramenta design para API, através da página disponibilizada para interação com o usuário é possível testar todas as APIS da aplicação diretamente do navegador

`http://localhost:8080/evaluation/swagger-ui/index.html`

Para auxiliar nos testes também foi criado uma Workspace na aplicação Postman, e para utilizá-la basta importar o arquivo:

`evaluation.postman_collection.json`

Que está localizado na raiz do projeto, em ambas alternativas todos os Endpoints poderão ser testados. 

Para qualquer dúvida estou à disposição para auxiliar.

