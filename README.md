JAVA
Rode o projeto via `.\gradlew bootRun`
Rota API:
`http://localhost:8080/api/notificar`

RABBITMQ
Configure o docker com o comando
`docker run -d --name rabbitmq  -p 5672:5672  -p 15672:15672  rabbitmq:3-management`
Acesse no painel `http://localhost:15672` com o usuário `guest` e senha `guest`
